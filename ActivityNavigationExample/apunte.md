### 1. **`RelativeLayout`**:
El **`RelativeLayout`** es un contenedor que permite organizar los elementos hijos en relación con otros elementos dentro de él.
- **`xmlns:android="http://schemas.android.com/apk/res/android"`**: Define el espacio de nombres XML para los atributos de Android.
- **`xmlns:tools="http://schemas.android.com/tools"`**: Define el espacio de nombres para los atributos relacionados con las herramientas de desarrollo (como Android Studio).
- **`android:layout_width="match_parent"`**: El ancho del `RelativeLayout` será igual al ancho de la pantalla del dispositivo.
- **`android:layout_height="match_parent"`**: La altura del `RelativeLayout` será igual a la altura de la pantalla del dispositivo.
- **`android:padding="16dp"`**: Añade un relleno de 16dp alrededor del contenedor, separando los elementos del borde de la pantalla.
- **`tools:context=".MainActivity"`**: Especifica que este diseño está asociado con la actividad `MainActivity` en Android Studio (para fines de desarrollo).

### 2. **`EditText`** (Campo de texto para ingresar una cadena):
Este campo permite al usuario ingresar texto.
- **`android:id="@+id/etCampoTexto"`**: Asigna un identificador único al campo de texto, que luego puede ser utilizado en el código Java para referirse a él.
- **`android:layout_width="match_parent"`**: El ancho del `EditText` ocupará todo el espacio disponible en la pantalla.
- **`android:layout_height="48dp"`**: Establece la altura del campo de texto a 48dp.
- **`android:hint="@string/placeholder"`**: Muestra un texto de sugerencia (hint) dentro del campo de texto, que se define en el archivo de recursos `strings.xml` como `@string/placeholder`.

### 3. **`EditText`** (Campo de texto para ingresar un número):
Este campo es similar al anterior, pero está diseñado para aceptar solo números.
- **`android:id="@+id/etCampoNumerico"`**: Asigna un identificador único al campo de texto numérico.
- **`android:inputType="number"`**: Especifica que este campo de texto solo acepta entradas numéricas, activando el teclado numérico en dispositivos que lo soportan.
- **`android:layout_width="match_parent"`**: El ancho del `EditText` ocupará todo el espacio disponible en la pantalla.
- **`android:layout_height="48dp"`**: Establece la altura del campo de texto a 48dp.
- **`android:layout_below="@+id/etCampoTexto"`**: Coloca este `EditText` debajo del campo de texto `etCampoTexto`.
- **`android:hint="@string/placeholder2"`**: Muestra un texto de sugerencia (hint) dentro del campo de texto, definido en el archivo `strings.xml` como `@string/placeholder2`.

### 4. **`Button`** (Botón para navegar):
El botón es utilizado para ejecutar una acción, como navegar a una nueva actividad.
- **`android:id="@+id/btnNavega"`**: Asigna un identificador único al botón, que se usará en el código Java.
- **`android:layout_width="wrap_content"`**: El ancho del botón se ajustará al contenido (es decir, al tamaño del texto).
- **`android:layout_height="wrap_content"`**: La altura del botón también se ajustará al contenido (el texto que contiene).
- **`android:layout_centerInParent="true"`**: Centra el botón en el medio del `RelativeLayout`, tanto horizontal como verticalmente.
- **`android:text="@string/btn_text"`**: El texto que aparece en el botón se obtiene del archivo de recursos `strings.xml` con la clave `@string/btn_text`.
- **`android:textAllCaps="false"`**: El texto del botón no se mostrará en mayúsculas automáticamente.

---

### Resumen de Propósitos de los Elementos y Atributos:

- **`RelativeLayout`**: Es el contenedor principal que organiza los elementos dentro de él de manera relativa, es decir, según la posición de otros elementos.
- **`EditText`**: Permite que el usuario ingrese texto. El primer campo es para texto libre y el segundo está configurado para ingresar solo números.
- **`Button`**: Un botón que ejecuta una acción cuando el usuario lo presiona. En este caso, está destinado a navegar a otra actividad.
- **`layout_width` y `layout_height`**: Definen el tamaño de los elementos. `match_parent` hace que el elemento ocupe todo el espacio disponible, y `wrap_content` ajusta el tamaño al contenido.
- **`layout_below` y `layout_centerInParent`**: Son atributos de disposición que permiten organizar los elementos de forma relativa, como colocar un campo de texto debajo de otro o centrar un botón en la pantalla.
- **`hint`**: Proporciona sugerencias visuales dentro de los campos de texto, indicando al usuario qué tipo de información debe ingresar.
