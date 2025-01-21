# Pinterest Login Test Projesi

Bu proje, Pinterest web sitesinin login arayüzünü test etmek amacıyla geliştirilmiştir. Projede hem manuel test senaryoları oluşturulmuş hem de bu senaryolar Selenium kullanılarak otomatize edilmiştir. Ayrıca, RESTful API testleri gerçekleştirilerek login işlemlerinin backend tarafındaki doğruluğu test edilmiştir.

---

## 🚀 Projenin Amaçları
- Pinterest web sitesinin login arayüzünü test etmek.
- Başarılı ve başarısız giriş işlemleri için manuel test senaryoları hazırlamak.
- Test senaryolarını Selenium kullanarak otomatize etmek.
- Login ile ilgili RESTful API işlemlerini test etmek.

---

## 🔧 Kullanılan Teknolojiler
- **Java:** Test senaryolarını oluşturmak ve yürütmek için temel programlama dili.
- **Selenium WebDriver:** Web arayüzü otomasyon testleri için.
- **TestNG:** Test yönetimi ve raporlama için kullanılan framework.
- **RestAssured:** RESTful API testlerini gerçekleştirmek için.
- **Allure Report:** Test sonuçlarını görselleştirmek için raporlama aracı.
- **Maven:** Proje bağımlılıklarını yönetmek ve build işlemlerini kolaylaştırmak için.

---

## 📂 Proje Yapısı
- **BaseTest:** 
  Ortak ayarların (tarayıcı başlatma, kapatma gibi) yer aldığı temel test sınıfı.
- **Pages:** 
  Pinterest login sayfası için gerekli elementleri ve işlemleri tanımlayan sayfa nesneleri.
  - `LoginPage`: Kullanıcı giriş işlemleri.
  - `MainPage`: Giriş sonrası doğrulama işlemleri.
- **Tests:**
  Test senaryolarının yazıldığı dosyalar.
  - `LoginTests`: Başarılı ve başarısız giriş işlemleri için yazılmış Selenium test senaryoları.
  - `UserRestApiTest`: Login işlemleriyle ilişkili API testleri.
- **Resources:**
  Test verilerinin yer aldığı dosyalar (örneğin, JSON payload'ları).

---

## 🧪 Gerçekleştirilen Testler
### **1. Manuel Testler**
- TC01 -> Başarılı giriş senaryosu: Doğru e-posta ve şifreyle giriş yapma işlemi.
- TC02 -> Başarısız giriş senaryosu: Geçersiz formda e-posta ve doğru şifreyle giriş yapma işlemi.
- TC03 -> Başarısız giriş senaryosu: Yanlış e-posta ve doğru şifreyle giriş yapma işlemi.
- TC04 -> Başarısız giriş senaryosu: Doğru e-posta ve yanlış şifreyle giriş yapma işlemi.

### **2. Otomasyon Testleri**
- Selenium kullanılarak manuel test senaryoları otomatize edilmiştir:
  - TC01 -> Doğru e-posta ve şifreyle başarılı giriş testi.
  - TC02 -> Geçersiz formda e-posta ve doğru şifreyle giriş testi (Başarısız giriş).
  - TC03 -> Yanlış e-posta ve doğru şifreyle giriş testi (Başarısız giriş).
  - TC04 -> Doğru e-posta ve yanlış şifreyle giriş testi (Başarısız giriş).

### **3. RESTful API Testleri**
- Login işlemleriyle ilişkili API çağrıları test edilmiştir:
  - Yeni kullanıcı oluşturma (POST).
  - Kullanıcı bilgilerini okuma (GET).
  - Kullanıcı bilgilerini güncelleme (PUT).
  - Kullanıcı bilgileri güncellendi mi kontrolü (PUT).
  - Kullanıcıyı silme (DELETE).
  - Kullanıcı girişi (GET).
  - Kullanıcı çıkışı (GET).

---

## 📊 Test Raporu Sonuçları
- Proje kapsamında gerçekleştirilen testlerin sonuçları Allure Report kullanılarak görselleştirilmiştir.
- Test sonuçlarına burdan uluşabilirsiniz --> [Test Sonuçları](https://qa-pinterest-login-ui-api-rest-testing-project.vercel.app/#) 
  - ✅ Geçen Testler: 10
  - ❌ Başarısız Testler: 0
  - ⚠️ Atlanan Testler: 2
  - ⏱️ Toplam Süre: 2 dakika 53 saniye

