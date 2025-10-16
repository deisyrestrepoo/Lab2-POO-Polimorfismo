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