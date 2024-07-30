<div dir="rtl">

# Exp3

## گزارش

### Json Simple Report:

مطابق آزمایش نخست فایل مربوطه را import کرده‌ایم:
![image](https://github.com/user-attachments/assets/f695ebff-0b81-48c8-ace2-9fe2bbdd87e7)

سپس با Run Test Json With نتیجه‌ای مطابق داریم:
![image](https://github.com/user-attachments/assets/27dfc2b7-1541-4703-b5e7-be3fae63c4ee)

اما باتوجه به اینکه کاورج به دست آمده نشان داده نشده است مطابق دستور کار آن را نمایش می‌دهیم:
![image](https://github.com/user-attachments/assets/113b180e-20f3-4623-a85e-1e08667f8f69)

برای نمایش بیشتر روند کار، عکس‌هایی از فرایند دیباگ قرار می‌دهیم.
![image](https://github.com/user-attachments/assets/a789cd63-c381-4acc-a6b3-c1f50d3a4ca0)
![image](https://github.com/user-attachments/assets/3ff59fd0-f7f0-4714-8bb1-2448abb919f3)
![image](https://github.com/user-attachments/assets/8c57b705-cb60-4246-a05a-8aad3f63e269)
![image](https://github.com/user-attachments/assets/e4c94576-96db-4330-84ec-0c3685de5bba)
![image](https://github.com/user-attachments/assets/4902b9a4-352d-4373-9f39-205c8925b9c3)
![image](https://github.com/user-attachments/assets/4233d4a3-ab3e-4db3-9aad-03be141b9ef4)

در اینجا گزارش Generate Coverage Report را در قالب HTML داریم:
![image](https://github.com/user-attachments/assets/b7de5afe-2bc4-4d84-8a22-eb1a1023ffc5)
![image](https://github.com/user-attachments/assets/84306c65-f474-4a3f-a856-25b7d97bb037)

حال با کلیک بر روی هر بخش، جزئیات بخش‌های کاور نشده (بخش قرمز) و بخش‌های کاور شده (بخش سبز) را داریم:
![image](https://github.com/user-attachments/assets/beb2a8d9-6aae-4367-a61c-7c14d2cc75dd)

### پروژه library:

##### قسمت searchBooks:

در enum انواع فیلد جستجو، ۴ مورد ایدی، نام، نویسنده و موضوع قرار داده شده است. در تابع searchBooks، جستجو براساس نام
مجاز نیست، پس برای این مورد، یک تست نوشته‌ایم که در صورت برخورد با جستجو براساس نام، یک exception رخ دهد. چون این تست
پاس نشده است، عملکرد آن را در تابع searchBooks پیاده‌سازی می‌کنیم تا تست پاس شود. سپس برای این مورد که در صورت پیدا
نکردن موردی که جستجو برای یافتن آن انجام شده است، باید null برگردانده شود، تست می‌نویسیم و از آنجایی که تست آن پاس
می‌شود، چیزی را پیاده‌سازی نمی‌کنیم.

سپس نوبت به بازآرایی می‌رسد. در هر مورد یک اینستنس از کتابخانه ساخته شده است که آن را می‌توانیم به setup ببریم و از
تکرار اجتناب کنیم.

بعد از آن، باید تست‌های مربوط به جستجو براساس ایدی، نویسنده و موضوع را بنویسیم و هر مورد را جداگانه در تابع اصلی
پیاده‌سازی کنیم تا تست‌ها پاس شوند. باز هم به سراغ بازآرایی می‌رویم و متوجه می‌شویم که در هر تست، فرآیند ساخت و اضافه
کردن کتاب به کتابخانه وجود دارد و با بردن آن به setup، باز هم از تکرار جلوگیری می‌کنیم.

مورد آخر نیز، تایپ key باید با فیلد جستجو همخوانی داشته باشد. یعنی برای ایدی، همگی عدد و برای نویسنده و موضوع، رشته
باشند. برای این امر، تست آن نوشته می‌شود تا یک exception رخ دهد و سپس این چک کردن تایپ را در searchBooks پیاده‌سازی
می‌کنیم.

##### قسمت searchStudents:

برای قسمت searchStudents نیز به همین منوال عمل کرده ایم و با رویکرد TDD این متود را نیز پیاده‌سازی کردیم اما طی
بازآرایی‌های متعددی که در طی سومین استپ از چرخه‌ی TDD یعنی ریفکتور کردن روی کد اجرا شد نهایتا به سیستم فعلی بر روی کد
رسیدیم.

کد فعلی، لاجیک مچ شدن با لیستی از کلید‌هایی که به سمت متود های سرچ چه برای Student و چه برای Book می‌آمد را متودی از یک
Interface جدا و خودتعریف به نام Searchable کرد که Student و Book آن را implements میکردند و وظیفه آن ها بود تا این مچ
شدن را به نفع خود و با منظق خود override کنند. سپس در کلاس Library تابع سرچ کوچکی صرفا از تابع مچ نوع داده‌هایی که
Searchable را پیاده‌سازی می‌کردند استفاده می‌کرد تا عملیات سرچ را ساختارمندانه تر انجام دهد. از ظرفی دو تابع ابتدایی ما
یعنی searchBooks و searchStudents تنها از این تابع سرچ به نفع خود استفاده می‌کردند و آن را فراخوانی می‌کردند.

در نهایت نیز تمام تست‌ها، پیاده سازی‌ها و بازآرایی‌ها طبق نگرش TDD انجام شد و تمام ملزمات پروژه برای این بخش برآورده شد.

##### قسمت lendBook و returnBook:

برای این بخش نیز طبق رویکرد TDD تست ها نوشته شد و از طریق همین سناریو‌های تست مشکلات و باگ‌های موجود در این دو تابع
نمایان شد، سپس پیاده سازی درست مربوط به این باگ‌ها انجام گرفت و در نهایت مرحله بازآرایی بر روی هر چرخه اعمال می‌شد و
چرخه بعدی شروع می‌شد. به همین ترتیب هر دو باگ موجود حل و فصل شدند.

#### برای اطلاعات بیشتر راجع به روند جزئی تر پروژه می‌توانید نگاهی به کامیت مسیج های ما بیاندازید

### سوال‌ها

**1. مقایسه روش TDD با روش تست سنتی از نظر نوع پروژه‌ها:**

- **TDD**: این روش به وضوح رویکردی هدفمند دارد. با توجه به اینکه ابتدا تست‌ها نوشته می‌شوند، از ابتدا مشخص است که قرار
  است چه کارهایی انجام دهیم. این روش از کارهای اضافه و وسواس در کد زدن پیشگیری می‌کند، چرا که ما از ابتدا خواسته‌ها از
  کد را با تست نوشتن مشخص کرده‌ایم و از طرفی هم کد بهینه‌تر و باکیفیت‌تری داریم. در نتیجه این رویکرد هدفمندانه برای
  پروژه‌های حساس بزرگ و بلندمدت قابل استفاده است. با توجه به تست‌های اولیه‌ای که نوشتیم و اینکه در راستای آن کدنویسی
  می‌کنیم، پوشش کد بالایی داریم و به باگ‌های کمتری برمی‌خوریم.
- **روش سنتی**: در این روش، با توجه به اینکه همان اول کار دست به کد می‌شویم، سرعت بیشتری داریم اما لزوماً کد ما در
  طولانی‌مدت نیازهایمان را برآورده نخواهد کرد. این روش برای پروژه‌های کوچک و موقت که پایداری کمتری نیاز دارند مناسب است.
  از طرفی چون خود کد را تغییر می‌دهیم، این روش منعطف‌تر بوده و اگر نیاز به تغییرات سریع در پیشبرد پروژه داشته باشیم، روش
  سنتی جوابگوی ما خواهد بود.

**2. تست‌ها در فرایند ایجاد نرم‌افزار توسط تیم توسعه و تیم تضمین کیفیت:**

- **تیم توسعه (Development Team)**:
    - **تست‌های واحد (Unit Testing)**: بررسی عملکرد قسمت‌های کوچک و مستقل کد.
    - **تست‌های یکپارچگی (Integration Testing)**: بررسی تعامل بین گروه‌های مختلف کد.
- **تیم تضمین کیفیت (QA Team)**:
    - **تست‌های عملکرد (Performance Testing)**: بررسی رفتار نرم‌افزار تحت بارهای مختلف.
    - **تست‌های کارایی (Usability Testing)**: ارزیابی تجربه کاربری و کاربرپسند بودن نرم‌افزار.
    - **تست‌های پذیرش کاربر (User Acceptance Testing)**: اطمینان از پاسخگویی نرم‌افزار به نیازهای کاربران نهایی.

**3. روال پروژه json-simple برای پروژه فعلی:**

- برای به دست آوردن اعداد پوشش آزمون، بر روی پکیج java در مسیر test کلیک راست کرده و گزینه Coverage with Tests All Run
  را انتخاب کنید.

  ![library_test_coverage_i](https://github.com/user-attachments/assets/f2ecc9ac-f95e-4736-988c-c741e6e0f1dd)
  همانطور که مشاهده می‌کنید پروژه از پوشش خوبی برخوردار است اما در فاز بعدی سعی می‌کنیم این پوشش را حداکثری کنیم.

**4. افزودن بخش‌هایی به کد تست برای بهبود اعداد پوشش آزمون:**

- بخش‌های معنادار به کد تست اضافه کنید تا درصد پوشش آزمون افزایش یابد. بخش‌هایی که اضافه می‌شوند باید کارآمد باشند و
  صرفاً فراخوانی ساده کلاس یا متد بدون استفاده در بخش‌های دیگر کد کافی نیست.

با افزودن تست های بیشتر برای همه کلاس‌ها و البته پوشاندن تقریبا‌ همه‌جای پروژه از انواع تست و سپس بازآرایی های لازم به
منظور جداسازی تست‌های کلاس Student و Book از Library و نهایتا اعمال AAA (Arrange-Act-Assert) به کاورج زیر رسیدیم:

  ![library_test_coverage_ii](https://github.com/user-attachments/assets/91ed7be4-7ee8-461a-95ac-2c82cc20d74c)


پایان!

</div>
