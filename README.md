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

bash
Copiar código
git clone -b master https://github.com/usuario/repositorio.git
Reemplaza https://github.com/usuario/repositorio.git con la URL del repositorio que deseas clonar.

2. Abrir el Proyecto en Android Studio
Abre Android Studio.
En la pantalla principal, selecciona Open o ve al menú File > Open....
Navega hasta el directorio donde clonaste el repositorio.
Selecciona la carpeta principal del proyecto y haz clic en OK.
3. Sincronizar Gradle
Una vez que el proyecto se abra, Android Studio detectará automáticamente los archivos build.gradle.
Si se te solicita sincronizar el proyecto con Gradle, haz clic en Sync Now.
Espera a que el proceso de sincronización termine. Si aparecen errores, sigue las instrucciones para resolverlos (pueden estar relacionados con versiones de Gradle o dependencias faltantes).
4. Verificar la Configuración del SDK
Asegúrate de que Android Studio esté configurado con la versión correcta del SDK de Android para el proyecto.
Ve a File > Project Structure... > SDK Location.
Confirma que el "Android SDK" apunte a una versión compatible con el proyecto.
5. Ejecutar la Aplicación
Conecta un dispositivo Android o inicia un emulador desde Android Studio.
Haz clic en el botón Run (el ícono de play) en la barra de herramientas.
Selecciona el dispositivo de destino y espera a que se compile y ejecute la aplicación.
css
Copiar código
