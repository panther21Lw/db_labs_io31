# Модель прецедентів

### PullInfo

@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :відправляє запит на отримання інформації;
    
    |Система|
    :система перевіряє наявність інформації;
    note right #d10000
    <b>Possible error:
    - InfoNotFoundExeption
    end note
    
    :повертає інформацію;
    |Користувач|
    stop

@enduml

### UpdateInfo

@startuml

    skinparam ActivityBackgroundColor #f5f5f5

    |Адміністратор|
    start
    :відправляє запит на оновлення;
    
    |Система|
    :система перевіряє актуальність інформації;
    note right #d10000
    <b>Possible error:
    - NoNewInfoExeption
    end note
    
    :оновлює інформацію;
    |Адміністратор|
    stop

@enduml

### CheckInfo
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Адміністратор|
    start
    :відправляє запит на перевірку на достовірність;
    
    |Система|
    :система перевіряє достовірність інформації;
    note right #d10000
    <b>Possible error:
    - NoFalseInfoExeption
    end note
    
    :оновлює інформацію;
    |Адміністратор|
    stop

@enduml


### Guest.Search
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Гість|
    start
    :натискає кнопку "Пошук" на головній сторінці сайту системи;
    :Гість вводить інформацію для пошуку;
    |Система|
    :виконує пошук інформації;
    note right #d10000
    <b>Possible error:
    - Guest.DataNotFound
      - Guest.PermissionError
      end note
    
    :повертає гостеві знайдену інформацію;
    |Гість|
    stop

@enduml

### Guest.Registration
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Гість|
    start
    :натискає кнопку "Зареєструватися" на головній сторінці сайту системи;
    |Система|
    :надає користувачу форму для реєстрації;
    |Гість|
    :заповнює форму для реєстрації та відправляє її у систему;
    |Система|
    :перевіряє коректність заповнення форми;
    note right #d10000
    <b>Possible error:
    - Guest.RegistrationFormIncorrectInput
      - Guest.RegistrationFormIncorrectEmail
      end note
      :створює обліковий запис користувача з даними, які вказані у формі для реєстрації;
      :сповіщає гостя про результати створення облікового запису;
      |Гість|
      stop
- 
@enduml

### Guest.Login
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Гість|
    start
    :натискає кнопку "Увійти до облікового запису";
    |Система|
    :створює форму для входу в обліковий запис та надсилає її гостьовому користувачеві;
    |Гість|
    :заповнює форму та відправляє її у систему;
    |Система|
    :перевіряє коректність заповнення полів форми;
    note right #d10000
    <b>Possible error:
    - Guest.LoginFormDaraError
    - Guest.LoginDataError
    end note
    :шукає у базі обліковий запис із даними, що внесені у форму;
    :знаходить обліковий запис із вказаними даними;
    :перенаправляє користувача в особистий кабінет;
    |Гість|
    stop

@enduml

### Guest.UseFilters
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Гість|
    start
    :відкриває сторінку пошуку;
    :вводить дані для пошуку та вибирає параметри фільтрування результатів;
    |Система|
    :виконує пошук інформації;
    :відфільтровує результати відповідно до параметрів фільтрування;
    note right #d10000
    <b>Possible error:
    - Guest.NullResultFilter
    end note
    :відображає список даних відповідно до запиту;
    |Гість|
    stop

@enduml

### Guest.GetGraphics
@startuml
    
    skinparam ActivityBackgroundColor #f5f5f5
    |Гість|
    start
    :переходить на сторінку перегляду даних;
    :обирає конкретні дані або категорію даних для перегляду;
    :обирає спосіб отримання даних: у вигляді таблиць, графіків чи діаграм;
    |Система|
    :візуалізує обрані дані у заданому вигляді;
    note right #d10000
    <b>Possible error:
    - Guest.GraphicsPermissionError
      - Guest.GraphicsDataUnavailable
      end note
      :повертає гостеві візуалізовані дані;
      |Гість|
      stop

@enduml

### Guest.GetReport
@startuml
    
    skinparam ActivityBackgroundColor #f5f5f5
    |Гість|
    start
    :переходить до розділу "Аналітичні звіти";
    :натискає кнопку "Отримати звіти";
    :обирає потрібний звіт або категорію звітів;
    |Система|
    : перевіряє доступність звіту для незареєстрованого користувача;
    note right #d10000
    <b>Possible error:
    - Guest.GetReportPermissionError
      - Guest.GetReportCurrentlyUnavailable
      end note
      :надає гостеві звіт для перегляду у веб-інтерфейсі;
      |Гість|
      stop

@enduml

### User.RequestSetting
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :переходить до розділу "Розширений доступ до даних";
    :обирає меню для створення запиту;
    |Система|
    :надає користувачу форму для створення запиту;
    |Користувач|
    :заповнює форму, обирає параметри для формування запиту та надсилає форму у систему;
    |Система|
    :перевіряє правильність заповнення полів форми;
    note right #d10000
    <b>Possible error:
    - User.DataNotAvailable
      - User.GenerateRequestError
      - User.IncorrectInput
      end note
      :генерує дані відповідно до запиту;
      :надає згенеровані дані користувачу;
      |Користувач|
      :переглядає дані або експортує їх у потрібному форматі;
      stop

@enduml

### User.SaveFilters
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :задає параметри фільтрації даних;
    :обирає опцію "Зберегти фільтр";
    |Система|
    :надає користувачеві форму для збереження фільтра;
    |Користувач|
    :заповнює форму та надсилає її у систему;
    |Система|
    :перевіряє коректність заповнення форми;
    note right #d10000
    <b>Possible error:
    - User.NoOptionsFilterError
      - User.FilterNameError
      end note
      :повідомляє користувача про збереження фільтра;
      |Користувач|
      stop

@enduml

### User.DataUpdateNotification
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :переглядає список доступних наборів даних;
    :обирає набір даних, на який хоче підписатися та натискає на кнопку "Оформити підписку";
    |Система|
    :додає підписку на набір даних, який обрав користувач;
    note right #d10000
    <b>Possible error:
    - User.SubscribeDontAllowed
      - User.SubscriptionAlreadyDone
      end note
      :надсилає сповіщення в особистий кабінет користувача при оновленні набору даних;
      |Користувач|
      stop

@enduml

### User.DownloadReport
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :обирає набір даних за допомогою інструментів пошуку та фільтрування;
    :натискає кнопку "Завантажити звіт";
    |Система|
    :надсилає користувачеві форму для вибору формату завантаження;
    |Користувач|
    :заповнює форму та відправляє її у систему;
    |Система|
    :перевіряє коректність заповнення полів у формі;
    note right #d10000
    <b>Possible error:
    - User.ReportFormatUnavailable
    - User.ReportGenerationError
    end note
    :генерує звіт у вибраному форматі та передає його користувачеві;
    |Користувач|
    :завантажує отриманий файл на пристрій;
    stop
@enduml
 
### User.LeaveComment
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :переглядає набір даних;
    :натискає кнопку "Додати коментар";
    |Система|
    :перевіряє чи дозволено до набору даних, який обрав користувач, додавати коментарі;
    :створює вікно для введення коментарів та надсилає його користувачу;
    |Користувач|
    :вводить коментар та натискає кнопку "Зберегти коментар";
    |Система|
    : перевіряє коментар;
    note right #d10000
    <b>Possible error:
    - User.CommentsDontAllowed
    end note
    :додає коментар до набору даних;
    :сповіщає користувача про успішне додавання коментаря;
    |Користувач|
    stop

@enduml

### User.TeamWork
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач1|
    start
    :відкриває набір даних, над яким хоче працювати у групах;
    :натискає кнопку "Додати користувача";
    |Система|
    :створює форму для додавання користувача та передає її Користувачу1;
    |Користувач1|
    :заповнює форму та повертає її у систему;
    |Система|
    :перевіряє правильність заповнення форми;
    note right #d10000
    <b>Possible error:
    - User.UserNotExistError
    end note
    :надсилає Користувачу2 запрошення про участь у роботі у групі;
    :сповіщає Користувача1 про успішне відправлення запрошення до Користувач2;
    |Користувач2|
    :заходить в особистий кабінет та приймає рішення про участь у групі;
    note right #d10000
    <b>Possible error:
    - User.GroupInviteReject  
    end note
    |Система|
    :додає Користувача2 до розробників набору даних Користувача1;
    stop_

@enduml

### User.SendAddNewDataRequest
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :відкриває у своєму особистому кабінеті нові дані, які хоче внести у систему;
    :натискає кнопку "Запросити додавання нових даних";
    |Система|
    :створює форму та надсилає її користувачеві;
    |Користувач|
    :вводить інформацію про дані та прикріпляє самі дані;
    :Відправляє форму у систему;
    |Система|
    :аналізує правильність заповнення форми;
    note right #d10000
    <b>Possible error:
    - User.IncorectDataInRequest
    end note
    :реєструє запит та надсилає сповіщення адміністратору;
    |Адміністратор|
    :отримує запит у своєму інтерфейсі для подальшого розгляду;
    stop

@enduml

### User.SendDataUpdateRequest
@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :відкриває у своєму особистому кабінеті нові дані, які хоче внести у систему;
    :натискає кнопку "Запросити оновлення даних";
    |Система|
    :створює форму та надсилає її користувачеві;
    |Користувач|
    :вводить інформацію про дані та прикріпляє самі дані;
    :Відправляє форму у систему;
    |Система|
    :аналізує правильність заповнення форми;
    note right #d10000
    <b>Possible error:
    - User.IncorectDataUpdateRequest
    end note
    :реєструє запит та надсилає сповіщення адміністратору;
    |Адміністратор|
    :отримує запит у своєму інтерфейсі для подальшого розгляду;
    stop

@enduml

### User.Logout

@startuml

    skinparam ActivityBackgroundColor #f5f5f5
    |Користувач|
    start
    :заходить до особистого кабінету;
    :натискає кнопку "Вийти з облікового запису";
    |Система|
    :перенаправляє користувача на головну сторінку та присвоює користувачеві роль Гість;
    stop

@enduml

### Admin.UserAccessSettings

### Admin.UpdateDataRequest

### Admin.GetUserActivity

### Admin.UploadNewData

### Admin.EditData

### Admin.RemoveData
