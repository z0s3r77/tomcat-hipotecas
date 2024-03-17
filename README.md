# HIPOTECAS

Repositorio de la tarea "Hipoteques" de la asignatura de "despliegue de aplicaciones web"

## Modo de Uso

- Clonamos este repositorio
  `https://github.com/z0s3r77/tomcat-hipotecas.git`
  
- Dentro del directorio `tomcat-hipotecas` ejecutamos
  `docker-compose up -d`

- Abrimos el navegador y vamos a `localhost:8080/tomcat-hipotecas/index-hipotecas.jsp`


## Requisitos funcionales

Requisitos Funcionales:

- La aplicación debe permitir calcular la cuota mensual a pagar a partir de un capital, un interés y un plazo dados.
- La aplicación permitirá visualizar el cuadro de amortización si el usuario lo solicita.
- La aplicación debe permitir que un usuario se registre en la aplicación y obtenga un usuario y una contraseña asociados que le permitirán estar  identificado en la aplicación.
- Un usuario identificado debe poder ver las simulaciones de hipotecas que se han realizado en la aplicación junto con la fecha y hora en que las hizo. Estas se almacenarán en una tabla de la base de datos de la aplicación.
- Si un usuario identificado lo desea, debe poder volver a simular una hipoteca sin necesidad de introducir los datos, simplemente seleccionando la simulación entre las que ya ha realizado.
- Se deben registrar los errores como errores en un archivo llamado AppHipoteques.txt.
- Se debe registrar como debug en un archivo llamado AppHipoteques.txt todas las simulaciones que se realicen, tanto de un usuario identificado como si no lo es. Esto debe incluir la fecha, hora, IP, nombre de usuario y los datos de la simulación de la hipoteca (importe, interés y meses).

## Técnologias empleadas de desarrollo
### Java 15
### Junit 5 & Mockito
Junit5 y Mockito para tests.
### Maven
Gestor de dependencias.

## Técnologias de infraestructura
### Tomcat
### MySQL
### Docker
### Jenkins

![Página principal](https://github.com/z0s3r77/tomcat-hipotecas/assets/80277545/160076e5-7ac4-4af9-a577-640a8e39699b)



