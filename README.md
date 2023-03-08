# demoProject
demoProejct for Bear

GET
1. select All Account
http://localhost:8080/account

2. select only CREDIT_CARD type 
http://localhost:8080/account/search/accountType?accountType=CREDIT_CARD

3. select account id
http://localhost:8080/account/2
http://localhost:8080/account/1

4. search by cardName
http://localhost:8080/account/search?cardName=hanaCard
http://localhost:8080/account/search?cardName=KBcard

POST
1. withdraw money by AccountNumber
http://localhost:8080/account/withdraw?account_number=344565667&money=50000
http://localhost:8080/account/withdraw?account_number=344565667&money=3845

2. withdraw money by AccountNumber error exception and validation
http://localhost:8080/account/withdraw?account_number=344565667&money=999999999
http://localhost:8080/account/withdraw?account_number=2332&money=50000

3. withdraw money by AccountNumber
http://localhost:8080/account/withdraw?account_number=778687887&money=50000
