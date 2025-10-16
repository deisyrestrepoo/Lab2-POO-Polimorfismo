# 📚 Documentación del Sistema de Logística

## 🎯 Descripción General

Este proyecto implementa un sistema de gestión de envíos que permite manejar diferentes tipos de transporte (Terrestre, Aéreo, Fluvial) aplicando principios de Programación Orientada a Objetos (POO) y los principios SOLID.

## 🏗️ Arquitectura del Sistema

### Estructura de Carpetas
```
src/
├── modelos/           # Capa de Modelo - Entidades de negocio
│   ├── Envio.java     # Clase abstracta base
│   ├── Terrestre.java # Implementación para envíos terrestres
│   ├── Aereo.java     # Implementación para envíos aéreos
│   ├── Fluvial.java   # Implementación para envíos fluviales
│   └── TipoEnvio.java # Enum con tipos de envío
├── servicios/         # Capa de Servicio - Lógica de aplicación
│   └── EnvioServicio.java
├── FrmLogistica.java  # Capa de Presentación - Interfaz gráfica
└── App.java          # Punto de entrada de la aplicación
```

## 📋 Funcionalidades Implementadas

### ✅ Gestión de Envíos
- **Agregar Envío**: Crear nuevos envíos con validación completa
- **Eliminar Envío**: Quitar envíos con confirmación del usuario
- **Listar Envíos**: Mostrar todos los envíos en una tabla

### ✅ Tipos de Envío Soportados
1. **Terrestre**: $1,500/km + $2,000/kg
2. **Aéreo**: $5,000/km + $4,000/kg  
3. **Fluvial**: $800/km + $1,000/kg

## 🔧 Principios POO Aplicados

### 1. **Herencia**
```java
// Clase abstracta base
public abstract class Envio {
    // Atributos comunes
    // Métodos abstractos
}

// Clases hijas que heredan
public class Terrestre extends Envio {
    // Implementación específica
}
```

### 2. **Polimorfismo**
```java
// Cada tipo implementa calcularTarifa() de manera diferente
public double calcularTarifa() {
    return getDistancia() * 1500 + getPeso() * 2000; // Terrestre
    return getDistancia() * 5000 + getPeso() * 4000; // Aéreo
    return getDistancia() * 800 + getPeso() * 1000;  // Fluvial
}
```

### 3. **Encapsulación**
```java
private String codigo;        // Atributos privados
private String cliente;
private double peso;
private double distancia;

public String getCodigo() {   // Acceso controlado mediante getters
    return codigo;
}
```

## 🎯 Principios SOLID Implementados

### 1. **S - Single Responsibility Principle**
- `Envio`: Solo maneja datos y lógica de envío
- `EnvioServicio`: Solo maneja operaciones CRUD
- `FrmLogistica`: Solo maneja la interfaz de usuario

### 2. **O - Open/Closed Principle**
- Fácil agregar nuevos tipos de envío sin modificar código existente
- Solo crear nueva clase que extienda `Envio`

### 3. **L - Liskov Substitution Principle**
- Cualquier subtipo de `Envio` puede usarse como `Envio` genérico
- Comportamiento consistente en todas las subclases

### 4. **I - Interface Segregation Principle**
- Interfaces específicas para cada necesidad
- No hay dependencias innecesarias

### 5. **D - Dependency Inversion Principle**
- La interfaz depende del servicio, no de implementaciones concretas
- El servicio depende de la abstracción `Envio`

## 📊 Flujo de Datos

```mermaid
graph TD
    A[Usuario en FrmLogistica] --> B[EnvioServicio.agregar()]
    B --> C[Crear objeto según tipo]
    C --> D[calcularTarifa() - Polimorfismo]
    D --> E[Almacenar en List<Envio>]
    E --> F[Actualizar tabla]
```

## 🚀 Cómo Ejecutar

### Compilación
```bash
javac -d bin -cp src src/*.java src/modelos/*.java src/servicios/*.java
```

### Ejecución
```bash
java -cp bin App
```

## 📝 Validaciones Implementadas

### Campos Obligatorios
- Código del envío
- Nombre del cliente
- Peso (debe ser positivo)
- Distancia (debe ser positiva)

### Validaciones Numéricas
- Peso y distancia deben ser números válidos
- Valores deben ser positivos
- Manejo de excepciones `NumberFormatException`

### Confirmaciones
- Confirmación antes de eliminar envío
- Mensajes de éxito y error apropiados

## 🎨 Interfaz de Usuario

### Componentes Principales
- **Barra de Herramientas**: Botones con iconos para agregar/quitar
- **Formulario de Edición**: Campos para datos del envío
- **Tabla de Datos**: Muestra todos los envíos con formato

### Características de UX
- Tooltips en botones
- Mensajes informativos
- Confirmaciones antes de acciones destructivas
- Formulario se limpia automáticamente

## 🔍 Código Comentado

Todo el código incluye comentarios detallados que explican:

### Para cada clase:
- **Propósito**: Qué hace la clase
- **Responsabilidades**: Cuáles son sus funciones
- **Principios aplicados**: Qué patrones de diseño usa

### Para cada método:
- **Funcionalidad**: Qué hace el método
- **Parámetros**: Qué recibe y qué significa cada uno
- **Valor de retorno**: Qué devuelve y en qué formato
- **Excepciones**: Qué errores puede generar

### Para cada sección de código:
- **Lógica**: Por qué se hace de esa manera
- **Flujo**: Cómo se relaciona con otras partes
- **Validaciones**: Qué se está verificando

## 📈 Ventajas de esta Implementación

### 1. **Mantenibilidad**
- Código bien documentado y organizado
- Separación clara de responsabilidades
- Fácil localizar y corregir errores

### 2. **Extensibilidad**
- Agregar nuevos tipos de envío es trivial
- Cambiar cálculos de tarifa es simple
- Modificar interfaz no afecta lógica de negocio

### 3. **Reutilización**
- Los modelos se pueden usar en otras aplicaciones
- El servicio es independiente de la interfaz
- Lógica de negocio reutilizable

### 4. **Testabilidad**
- Cada capa se puede probar independientemente
- Métodos pequeños y enfocados
- Separación clara de responsabilidades

## 🎓 Conceptos de POO Demostrados

1. **Abstracción**: Clase abstracta `Envio`
2. **Herencia**: `Terrestre`, `Aereo`, `Fluvial` extienden `Envio`
3. **Polimorfismo**: `calcularTarifa()` implementado diferente en cada clase
4. **Encapsulación**: Atributos privados con getters públicos
5. **Composición**: `FrmLogistica` usa `EnvioServicio`
6. **Factory Pattern**: `EnvioServicio.agregar()` crea objetos según tipo

## 🔧 Tecnologías Utilizadas

- **Java**: Lenguaje de programación
- **Swing**: Biblioteca para interfaz gráfica
- **AWT**: Componentes básicos de interfaz
- **JUnit**: Para pruebas unitarias (opcional)

## 📚 Patrones de Diseño Aplicados

1. **Template Method**: Clase abstracta con métodos concretos y abstractos
2. **Factory Method**: Creación de objetos según tipo
3. **MVC**: Separación Modelo-Vista-Controlador
4. **Observer**: Eventos de interfaz de usuario
5. **Strategy**: Diferentes algoritmos de cálculo de tarifa

---

*Esta documentación proporciona una guía completa para entender, mantener y extender el sistema de logística implementado.*
