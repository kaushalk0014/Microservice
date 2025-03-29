
http://localhost:9292/h2-console/login.do?jsessionid=0c5a10f03ee35fd70bb35d3791f441d7

POST http://localhost:9191/order/bookOrder

{
    "order":{
        "name":"Phone",
        "price":50000,
        "qty":5
    },
    "payment":{
        "amount":5000
    }
    
}

POST: http://localhost:9292/payment/doPayment

{
    "paymentStatus":"success"
}


