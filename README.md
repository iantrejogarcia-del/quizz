# Quiz Materias

Aplicación Android de preguntas y respuestas de opción múltiple sobre tres materias: **Historia**, **Geografía** y **Física**. Al terminar cada cuestionario muestra la puntuación y un mensaje según el desempeño.

## Funcionalidades

- Tres categorías con **10 preguntas cada una**, cargadas desde archivos JSON.
- Cada pregunta tiene **4 opciones** y el orden de las preguntas es aleatorio en cada intento.
- Retroalimentación inmediata al elegir una respuesta y avance automático a la siguiente pregunta.
- Pantalla de resultados con respuestas correctas e incorrectas, **5 puntos por acierto** y un mensaje con imagen según el desempeño.
- Pantalla de información con términos y condiciones y enlaces a las redes sociales del proyecto.
- Confirmación al intentar salir de la aplicación.

## Tecnologías

- Java
- Android SDK (Material Components, AppCompat, ConstraintLayout)
- Archivos JSON en `assets/` como banco de preguntas
- Gradle (Kotlin DSL)

## Requisitos

- Android Studio (versión reciente)
- Android 11 o superior (`minSdk 30`, `compileSdk 34`)
- JDK compatible con Java 8 o superior

## Cómo ejecutarlo

1. Clona el repositorio:
   ```bash
   git clone https://github.com/iantrejogarcia-del/quizz.git
   ```
2. Abre la carpeta del proyecto en Android Studio y espera a que termine la sincronización de Gradle.
3. Conecta un dispositivo Android o inicia un emulador.
4. Presiona **Run** para instalar y abrir la app.

## Estructura del proyecto

```
app/src/main/
├── assets/                  # Preguntas en JSON (Historia, Geografía, Física)
├── java/com/example/pedroproyect/
│   ├── MainActivity.java    # Menú principal con las categorías
│   ├── basico.java          # Cuestionario de Historia
│   ├── geografia.java       # Cuestionario de Geografía
│   ├── Fisica.java          # Cuestionario de Física
│   ├── ResultActivity.java  # Pantalla de resultados
│   ├── pregunta.java        # Información y enlaces
│   └── Terminos_con.java    # Términos y condiciones
└── res/                     # Diseños, imágenes y recursos
```

## Formato de las preguntas

Para agregar preguntas, edita los archivos de `assets/` siguiendo este formato:

```json
{
  "preguntas": "Geografía: ¿Cuál es el río más largo del mundo?",
  "respuesta1": "A) Nilo",
  "respuesta2": "B) Amazonas",
  "respuesta3": "C) Yangtsé",
  "respuesta4": "D) Misisipi",
  "correcto": "B) Amazonas"
}
```

## Posibles mejoras

- Unificar las tres pantallas de cuestionario en una sola actividad reutilizable.
- Agregar más preguntas y categorías.
- Guardar el historial de puntuaciones.

## Autor

**Ian Trejo García** — Estudiante de Ingeniería en Sistemas Computacionales
GitHub: [iantrejogarcia-del](https://github.com/iantrejogarcia-del)
