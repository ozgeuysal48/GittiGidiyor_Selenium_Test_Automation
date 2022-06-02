# GittiGidiyor_Selenium_Test_Automation
Proje Java, Maven, Selenium, JUnit, Log4J, OOP, Page Object Pattern kullanılarak yazılmıştır.

Expected:
- www.gittigidiyor.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
- Login işlemi kontrol edilir.
- Arama kutucuğuna bilgisayar kelimesi girilir.
- Arama sonuçları sayfasından 2.sayfa açılır.
- 2.sayfanın açıldığı kontrol edilir.
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir

Log4j Output:

2022-06-02 23:12:35 INFO  Log4j:30 - https://www.gittigidiyor.com/ home page opened.

2022-06-02 23:12:38 INFO  Log4j:35 - Advertisement closed and login button clicked.

2022-06-02 23:12:42 INFO  Log4j:40 - Home page opened.

2022-06-02 23:12:43 INFO  Log4j:44 - User x logged in. Verified that login is successful.

2022-06-02 23:12:55 INFO  Log4j:49 - The product bilgisayar searched and moved to next page.

2022-06-02 23:13:02 INFO  Log4j:53 - A product clicked randomly.

2022-06-02 23:13:02 INFO  Log4j:58 - Product price and name wrote to txt file.

2022-06-02 23:13:06 INFO  Log4j:63 - Product added to basket.

2022-06-02 23:13:07 INFO  Log4j:67 - Verified that actual price and expected price is the same.

2022-06-02 23:13:07 INFO  Log4j:71 - Product count in the basket increased by 1.

2022-06-02 23:13:08 INFO  Log4j:76 - Verified that # of product in basket is 2.

2022-06-02 23:13:09 INFO  Log4j:79 - Basket is empty.

2022-06-02 23:13:10 INFO  Log4j:84 - Verified that basket is empty.

2022-06-02 23:13:11 INFO  Log4j:102 - Test completed.


