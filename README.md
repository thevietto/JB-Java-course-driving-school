Some instructions going here


<h1>Connection with database</h1>
<h2>Module jbds-domain</h2>
in folder src/main/resources: 
<ul>
    <li>create 2 properties file</li>
    <li>name them database.properties and liquibase.properties</li>
    <li>then tune them as database.properties.example 
     and liquibase.properties.example respectively</li>
     </ul>
<p>changelog.xml file is for migrations</p>
<p>special profile and plugin for it you can see in pom.xml in jbds-domain module</p>

<h1>Настройка пути</h1>
<h2>Модуль jbds-web</h2>
в папке resources:

Создайте файл application.properties, по примеру существующего application.properties.example.
Установите переменной img.dir **абсолютный путь**
    до папки в вашей ОС, куда будут сохраняться картинки. Эта папка должна быть вне вашего проекта.
