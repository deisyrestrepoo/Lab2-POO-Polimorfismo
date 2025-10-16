# 📚 Documentación del Sistema de Logística

## 🎯 Descripción General

Este proyecto implementa un sistema de gestión de envíos que permite manejar diferentes tipos de transporte (Terrestre, Aéreo, Fluvial) aplicando principios de Programación Orientada a Objetos (POO) y buenas prácticas de diseño.

## 🏗️ Arquitectura del Sistema

### Estructura de Carpetas
```
src/
├── modelos/           
│   ├── Envio.java     
│   ├── Terrestre.java 
│   ├── Aereo.java     
│   ├── Fluvial.java   
│   └── TipoEnvio.java 
├── servicios/         
│   └── EnvioServicio.java
├── FrmLogistica.java  
└── App.java           
```

## 📋 Funcionalidades Implementadas

### ✅ Gestión de Envíos
- **Agregar Envío**: Crear nuevos envíos con validación de datos
- **Eliminar Envío**: Quitar envíos con confirmación del usuario
- **Listar Envíos**: Mostrar todos los envíos en una tabla

### ✅ Tipos de Envío Soportados
1. **Terrestre**: $1,500/km + $2,000/kg
2. **Aéreo**: $5,000/km + $4,000/kg
3. **Fluvial**: $800/km + $1,000/kg

## 🔧 Principios POO Aplicados

### 1. Herencia
- `Envio` es una clase abstracta base para los tipos de envío.
- `Terrestre`, `Aereo` y `Fluvial` extienden `Envio`.

### 2. Polimorfismo
- Cada subtipo implementa su propia versión de `calcularTarifa()` y `mostrarDatos()`.

### 3. Encapsulación
- Atributos de `Envio` son privados y se acceden mediante getters.

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

### Validación del Nombre del Cliente
- Mínimo: **1 carácter**; Máximo: **100 caracteres**.
- Palabras: **1 o más** 
- Sin espacios al inicio o al final.
- Sin múltiples espacios consecutivos.
- Caracteres permitidos en el texto completo: letras (incluye acentos y ñ/ü), espacios, punto (`.`), guion (`-`) y apóstrofe (`'`).
- Cada parte separada por espacio debe contener **solo letras** (incluye acentos y ñ/ü).

Mensajes de error específicos devueltos por la validación informan el motivo exacto (vacío, longitud, espacios indebidos, caracteres inválidos, etc.).

### Validaciones Numéricas
- `peso` y `distancia` deben ser numéricos y **mayores que 0**.
- Manejo de `NumberFormatException` con mensajes claros al usuario.

### Confirmaciones y Mensajes
- Confirmación antes de eliminar un envío.
- Mensajes de éxito y error en las operaciones clave.

## 🔁 Cálculo de Tarifas
- Terrestre: `distancia * 1500 + peso * 2000`
- Aéreo: `distancia * 5000 + peso * 4000`
- Fluvial: `distancia * 800 + peso * 1000`

---

Esta documentación refleja el estado actual del código, incluyendo la validación de nombre de cliente (mínimo 1 carácter y sin límite de palabras) y el conjunto de tipos de envío soportados (Terrestre, Aéreo y Fluvial).
