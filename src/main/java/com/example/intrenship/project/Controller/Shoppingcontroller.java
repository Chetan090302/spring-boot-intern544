package com.example.intrenship.project.Controller;
import com.example.intrenship.project.Entity.Order;
import com.example.intrenship.project.Entity.Shopping;
import com.example.intrenship.project.Entity.Transaction;
import com.example.intrenship.project.Entity.User;
import com.example.intrenship.project.Exception.ProductNotFound;
import com.example.intrenship.project.Repository.Orderrepo;
import com.example.intrenship.project.Repository.Shoppingrepo;
import com.example.intrenship.project.Repository.TransactionRepo;
import com.example.intrenship.project.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import static org.springframework.http.HttpStatus.*;
@RestController
public class Shoppingcontroller
{
    @Autowired
    Shoppingrepo shoppingrepo;
    @Autowired
    Orderrepo orderRepo;
    @Autowired
    Userrepo userRepository;
    @Autowired
    TransactionRepo transactionRepo;
    @GetMapping("/fetchCoupons")
    public HashMap<String,Integer> method45()
    {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("OFF%",5);
        hm.put("OFF10",10);
        return hm;
    }
    @PostMapping("/initialize")
    private Shopping method543()
    {
        Shopping s1=new Shopping(0,100,100);
        shoppingrepo.save(s1);
        return shoppingrepo.findAll().get(0);
    }
    @GetMapping("/inventory")
    public  Shopping getdetails()
    {
        return shoppingrepo.findAll().get(0);
    }
    @PostMapping("/post")
    public ResponseEntity<Shopping> method2(@RequestBody Shopping shop)
    {
        shoppingrepo.save(shop);
        HttpHeaders header=new HttpHeaders();
        header.add("h1","data stored successfully");
        return new ResponseEntity<>(shop,header,OK);
    }
    @GetMapping("/api")
    public ResponseEntity<Shopping> method1()
    {
        HttpHeaders header=new HttpHeaders();
        List<Shopping> lis=shoppingrepo.findAll();
        if(lis.isEmpty())throw new ProductNotFound("the orderid is not found in the database");
        else
        {
            header.add("data", "found in the database544");
            return new ResponseEntity(lis, header, NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Shopping> method2(@PathVariable Integer id)
    {
        shoppingrepo.deleteById(id);
        HttpHeaders header=new HttpHeaders();
        header.add("h1","deleted successfully");
        return new ResponseEntity<>(header,OK);
    }
    @PostMapping("/{userid}/order")
    public Order method3(@PathVariable Integer userid,@RequestParam Integer qty,@RequestParam String coupon)
    {
        List<Shopping> lis=shoppingrepo.findAll();
        Shopping s1=new Shopping();
        if(lis.size()!=0)
        {
            s1 = lis.get(0);
        }
        if(s1.getAvailable()<qty)
        {
            throw new ProductNotFound("description:Invalid quantity //Quantity is either less than 1 or more than the maximum quantity of product available");
        }
            String coupon1=coupon.trim();
            coupon1 = coupon1.replace("\"", "");
            Integer ordered1=s1.getOrdered();
            Integer price=s1.getPrice();
            Integer available=s1.getAvailable()-qty;
            Shopping s44=new Shopping(qty,price,available);
            shoppingrepo.deleteById(s1.getOrdered());
            shoppingrepo.save(s44);
            Integer amount1=qty*price;
        User user = userRepository.findById(userid).orElse(null);
        if(user!=null)
        {
            throw new ProductNotFound( "description:Invalid coupon //User has already used the coupon before, or coupon does not exist");
        }
        if (user == null)
        {
            if (coupon1.equals("OFF5"))
            {
                double fivePercent = amount1 * 0.05;
                amount1 -= (int) fivePercent;
            } else if (coupon1.equals("OFF10"))
            {
                double tenPercent = amount1 * 0.1;
                amount1 -= (int) tenPercent;
            }
        }
            Integer userid1=userid;
            Integer quantity1=qty;
            Random rand1=new Random();
            int orderid=rand1.nextInt(10,500);
            while(orderRepo.findById(orderid)==null)
            {
                orderid = rand1.nextInt(10, 500);
            }
            LocalDate currentDate = LocalDate.now();
            Order order=new Order(orderid,userid1,quantity1,amount1,coupon1,currentDate);
            orderRepo.save(order);
            User use1=new User(userid);
            userRepository.save(use1);
            return orderRepo.findById(orderid).orElse(null);
    }

    @PostMapping("/{userId}/{orderId}/pay")
    public Transaction method44(@PathVariable Integer userId,@PathVariable Integer orderId,@RequestParam Integer amount)
    {
        Order order=orderRepo.findById(orderId).get();
        if(order==null)throw new ProductNotFound("description:Payment Failed due to invalid order id");
        Random rand=new Random();
        int x=rand.nextInt(1,100);
        String status="successfull";
        String transaction = "tran01010000"+x;
        Transaction obj=new Transaction(orderId,userId,amount,transaction,status);
        transactionRepo.save(obj);
        return transactionRepo.findById(orderId).get();
    }
    @GetMapping("/{userId}/orders")
    public List<Order> method536(@PathVariable Integer userId, Model model)
    {
        List<Order> orderslist=orderRepo.findByuserId(userId);
        if(orderslist.isEmpty())throw new ProductNotFound("description:userid not found");
        return orderslist;
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public List<Transaction> method537(@PathVariable Integer orderId, Model model)
    {
        List<Transaction> translist=transactionRepo.findByorderId(orderId);
        if(translist.isEmpty())throw new ProductNotFound("description:Orderid not found");
        return translist;
    }
}
