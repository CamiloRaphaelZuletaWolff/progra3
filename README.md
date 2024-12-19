# Guía para Clonar un Repositorio en la Rama Master y Abrirlo en Android Studio

Este README describe los pasos para clonar un repositorio desde GitHub en la rama master y abrirlo en Android Studio.

## Requisitos Previos

- Tener **Git** instalado en tu sistema. Puedes descargarlo desde [git-scm.com](https://git-scm.com).
- Tener **Android Studio** instalado. Puedes descargarlo desde [developer.android.com/studio](https://developer.android.com/studio).

## Pasos

### 1. Clonar el Repositorio desde GitHub

1. Abre una terminal o la línea de comandos.
2. Navega al directorio donde deseas clonar el repositorio:
   
   ```bash
   cd /ruta/a/tu/directorio
Clona el repositorio asegurándote de especificar la rama master:

git clone -b master https://github.com/usuario/repositorio.git
Reemplaza https://github.com/usuario/repositorio.git con [la URL del repositorio que deseas clonar.](https://github.com/CamiloRaphaelZuletaWolff/progra3.git)

2. Abrir el Proyecto en Android Studio
Abre Android Studio.

En la pantalla principal, selecciona Open o ve al menú File > Open....

Navega hasta el directorio donde clonaste el repositorio.

Selecciona la carpeta principal del proyecto y haz clic en OK.

En el caso que no puedas clonar con comandos opta por esta opción:
Abre Android Studio
![Captura de pantalla 2024-12-19 004252](https://github.com/user-attachments/assets/ee7b09f3-a810-4604-99ae-3a340fa20ac5)
Entra a Get from VCS

Pegas este URL(https://github.com/CamiloRaphaelZuletaWolff/progra3) y TODO LISTO

![Captura de pantalla 2024-12-19 004329](https://github.com/user-attachments/assets/51939c7f-3fa9-4735-8777-b735b10051f9)

3. Sincronizar Gradle
Una vez que el proyecto se abra, Android Studio detectará automáticamente los archivos build.gradle.

Si se te solicita sincronizar el proyecto con Gradle, haz clic en Sync Now.

Espera a que el proceso de sincronización termine. Si aparecen errores, sigue las instrucciones para resolverlos (pueden estar relacionados con versiones de Gradle o dependencias faltantes).

OJO: si sale error en el gradle implementar google-services.json:


[google-services.json](https://github.com/user-attachments/files/18192218/google-services.json)

En este espacio:
![2153b06e-9aed-467f-8a06-3496f9134417](https://github.com/user-attachments/assets/67d314e6-94dd-42d8-941e-f9edef0ba3ef)


4. Verificar la Configuración del SDK
Asegúrate de que Android Studio esté configurado con la versión correcta del SDK de Android para el proyecto.

Ve a File > Project Structure... > SDK Location.

Confirma que el "Android SDK" apunte a una versión compatible con el proyecto.
![{1D65C4F3-B7CD-4B9D-A372-36F545E655DC}](https://github.com/user-attachments/assets/0894f8a1-0e78-4771-a357-576b9d1e5ee0)




5. Ejecutar la Aplicación
Conecta un dispositivo Android o inicia un emulador desde Android Studio.

Haz clic en el botón Run (el ícono de play) en la barra de herramientas.


# Instrucciones para el uso de la aplicación

## 1. Espera a que termine el splash inicial

Cuando inicies la aplicación, verás una pantalla de inicio (splash) que mostrará el logotipo y el nombre de la aplicación. Esta pantalla se mostrará brevemente antes de que puedas acceder a las funciones principales de la aplicación. Simplemente espera a que termine la animación para proceder al siguiente paso.

## 2. Inicia sesión o regístrate

Al finalizar el splash, serás dirigido a la pantalla de inicio de sesión. Si ya tienes una cuenta, ingresa tus credenciales (correo y contraseña) y presiona **Iniciar sesión**. 

Si no cuentas con una cuenta, busca y selecciona el enlace **NO TENGO CUENTA**. Este enlace te llevará a la pantalla de registro, donde podrás crear una cuenta nueva proporcionando tus datos básicos como nombre de usuario, correo electrónico y una contraseña segura. Una vez completado el registro, podrás iniciar sesión.

## 3. Crea una cuenta válida e inicia sesión

Al completar el registro, la aplicación validará tus datos. Asegúrate de ingresar información correcta y válida, como una dirección de correo electrónico activa. Después de registrarte correctamente, serás redirigido automáticamente a la pantalla principal, donde podrás iniciar sesión.

## 4. Navega por las opciones del menú principal

En la pantalla principal, verás varios íconos que te permitirán interactuar con la aplicación de diferentes maneras:

- **Ícono de Play (reproducir)**: Si deseas comenzar a jugar, presiona el ícono de **Play**. Esto te llevará a la pantalla de juego donde podrás interactuar con las cartas. 
- **Ícono de Persona (perfil)**: Si deseas ver tu perfil, que incluye tu nombre de usuario y correo, haz clic en el ícono de **Persona**. También puedes cerrar sesión desde esta sección, si lo deseas.
- **Ícono de Trofeo (estadísticas)**: Si deseas consultar tus estadísticas de juego, como el total de aciertos, el tiempo total jugado, el número de aciertos incorrectos y la cantidad de reinicios realizados, selecciona el ícono de **Trofeo**. Este ícono te llevará a una sección donde se muestran los resultados de tus partidas anteriores.

## 5. Jugar el juego

Al presionar el ícono de **Play**, serás llevado a la pantalla de juego, donde el objetivo principal es encontrar pares de cartas antes de que se agote el tiempo. El juego consiste en voltear las cartas haciendo clic sobre ellas. Cada carta tiene un par que debe ser encontrado en la misma sesión.

El temporizador comenzará a contar desde el momento en que inicies el juego. Tu objetivo es encontrar todos los pares posibles en el menor tiempo posible. Si logras hacerlo antes de que se termine el tiempo, ganarás el nivel y podrás avanzar al siguiente.

**Importante**: Para ganar un nivel, debes encontrar todos los pares dentro del tiempo límite. Si el tiempo se agota sin que hayas encontrado todos los pares, perderás el nivel y tendrás que reiniciarlo.

## 6. Opciones tras perder o ganar

- **Si pierdes**: En caso de no lograr encontrar todos los pares antes de que termine el tiempo, podrás reiniciar el nivel y volver a intentarlo. Esto te permitirá mejorar tu rendimiento y conocer mejor la disposición de las cartas.
  
- **Si ganas**: Si logras completar el nivel dentro del tiempo límite, podrás avanzar al siguiente nivel, que será más difícil. Los niveles en la aplicación son infinitos, lo que significa que siempre habrá un nuevo reto para superar. La dificultad aumenta conforme avanzas, lo que hará que el juego sea cada vez más desafiante.

Los niveles no tienen un límite, lo que permite una progresión continua en la que cada vez enfrentarás más desafíos y tendrás que mejorar tus habilidades para completar el juego.



