# TestSoapRest
Repositorio. Servicio Soap Java 11, Servicio rest conectado al soap.

# Requisitos

* Java 11 o Superior
* Maven
* Docker

# Pasos

* Estando docker encendido, ejecutar en la carpeta raiz del repositorio el comando "docker-compose up"
* Verificar que se creo la contenedor y esta encendido con el comando "docker ps"
* Importar las aplicaciones en el IDE de su elección como proyecto Maven
* Ejecutar las aplicaciones ( Spring-boot-soap )  y ( Spring-boot-web)
* Realizar la petición desde la herramienta de su preferencia Postman, SoapUi o consola
* Tomar de guia la consulta aqui descrita.

http://localhost:8081/api/consult/employee?name=LUIS CARLOS&lastName=HERNANDEZ&typeId=CC&id=2002&birthDate=29-Mar-2000&bondingDate=15-Mar-2020&position=DESARROLLADOR&salary=3848499

