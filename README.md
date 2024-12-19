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

3. Sincronizar Gradle
Una vez que el proyecto se abra, Android Studio detectará automáticamente los archivos build.gradle.

Si se te solicita sincronizar el proyecto con Gradle, haz clic en Sync Now.

Espera a que el proceso de sincronización termine. Si aparecen errores, sigue las instrucciones para resolverlos (pueden estar relacionados con versiones de Gradle o dependencias faltantes).

OJO: si sale error en el gradle implementar google-services.json:

[Uploading google-services.json{
  "project_info": {
    "project_number": "383851007435",
    "project_id": "recuerdin-65394",
    "storage_bucket": "recuerdin-65394.firebasestorage.app"
  },
  "client": [
    {
      "client_info": {
        "mobilesdk_app_id": "1:383851007435:android:34ac5edb730aed9a44ba4e",
        "android_client_info": {
          "package_name": "com.example.sinnombre"
        }
      },
      "oauth_client": [],
      "api_key": [
        {
          "current_key": "AIzaSyDIVquupIzxHfzpC5zEMkSCesTVdo75lWQ"
        }
      ],
      "services": {
        "appinvite_service": {
          "other_platform_oauth_client": []
        }
      }
    }
  ],
  "configuration_version": "1"
}…]()



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



# Cómo usar la aplicación

1. Deja que pase el splash.
2. Inicia sesión. En caso de no contar con una cuenta, ve al apartado de **NO TENGO CUENTA**.
3. Crea una cuenta válida e inicia sesión.
4. Pulsa el ícono de **play** si deseas jugar. Si quieres ver el perfil o cerrar sesión, ve al ícono de **persona**. Si deseas ver el total de aciertos, tiempo total jugado, total de incorrectos y total de reinicios, ve al ícono de **trofeo**.
5. Si presionas el ícono de **play**, pulsa las cartas para que se volteen. El objetivo es encontrar pares antes de que se acabe el tiempo.

En caso de que pierdas, podrás reiniciar el nivel, y si ganas, podrás pasar al siguiente. Los niveles son infinitos y cada vez más difíciles.


