-- Şema ve User kurulumu için.. SYSTEM kullanıcısıyla login olunup, bir kez çalıştırılacak..

CREATE USER hospital IDENTIFIED BY hospital123;

grant connect to hospital identified by hospital123;

grant all privileges to hospital identified by hospital123;

