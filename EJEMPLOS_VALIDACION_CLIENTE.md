# 🧪 Ejemplos de Validación del Nombre del Cliente

## ✅ **Nombres VÁLIDOS (se aceptan):**

### **Patrón 1: Nombre Apellido (2 palabras)**
- `Juan Pérez`
- `María García`
- `José López`
- `Ana Martínez`

### **Patrón 2: Nombre Apellido Apellido (3 palabras)**
- `Juan Pérez García`
- `María García López`
- `José López Martínez`
- `Ana Martínez Rodríguez`

### **Patrón 3: Nombre Nombre Apellido (3 palabras)**
- `Juan Carlos Pérez`
- `María Elena García`
- `José Antonio López`
- `Ana María Martínez`

### **Patrón 4: Nombre Nombre Apellido Apellido (4 palabras)**
- `Juan Carlos Pérez García`
- `María Elena García López`
- `José Antonio López Martínez`
- `Ana María Martínez Rodríguez`

### **Patrones Extendidos (5-8 palabras)**
- `Juan Carlos María Elena Pérez García` (5 palabras)
- `José Antonio María Elena López Martínez` (5 palabras)
- `Ana María José Carlos García López Martínez` (6 palabras)
- `Simón José Antonio de la Santísima Trinidad Bolívar` (8 palabras)
- `María Elena José Antonio Carlos García López Martínez` (7 palabras)

### **Nombres con Caracteres Especiales Válidos:**
- `José María` (con acento)
- `María José` (con acento)
- `José-María` (con guión)
- `María José` (con espacio)
- `José María` (con acento y espacio)
- `O'Connor` (con apostrofe)
- `Jean-Pierre` (con guión)
- `María José` (con acento)

### **Nombres con Caracteres Únicos Válidos:**
- `A B` (nombre de 1 carácter + apellido de 1 carácter)
- `J Pérez` (nombre de 1 carácter + apellido normal)
- `Juan P` (nombre normal + apellido de 1 carácter)
- `A García` (nombre de 1 carácter + apellido normal)
- `María J` (nombre normal + apellido de 1 carácter)

## ❌ **Nombres INVÁLIDOS (se rechazan):**

### **Problemas de Longitud:**
- `A` (muy corto - menos de 3 caracteres)
- `AB` (muy corto - menos de 3 caracteres)
- `Nombre muy largo que excede los cien caracteres permitidos por la validación del sistema de logística` (muy largo)

### **Problemas de Espacios:**
- ` Juan Pérez` (espacio al inicio)
- `Juan Pérez ` (espacio al final)
- `Juan  Pérez` (múltiples espacios)
- `Juan   Pérez` (múltiples espacios)
- ` Juan Pérez ` (espacios al inicio y final)

### **Problemas de Caracteres:**
- `Juan123 Pérez` (contiene números)
- `Juan@Pérez` (contiene símbolos no permitidos)
- `Juan#Pérez` (contiene símbolos no permitidos)
- `Juan$Pérez` (contiene símbolos no permitidos)
- `Juan%Pérez` (contiene símbolos no permitidos)

### **Problemas de Formato:**
- `Juan` (solo nombre, falta apellido)
- `Juan Carlos María Elena Pérez García López Martínez Rodríguez` (más de 8 palabras)
- `Simón José Antonio de la Santísima Trinidad Bolívar Ponte y Palacios Blanco` (más de 8 palabras)

### **Problemas de Partes Individuales:**
- `Juan123 Pérez` (primera parte contiene números)
- `Juan Pérez123` (segunda parte contiene números)

## 🔍 **Mensajes de Error Específicos:**

| Entrada | Mensaje de Error |
|---------|------------------|
| `""` (vacío) | "El nombre del cliente no puede estar vacío" |
| `"A"` | "El nombre del cliente debe tener al menos 3 caracteres" |
| `"AB"` | "El nombre del cliente debe tener al menos 3 caracteres" |
| `" Juan Pérez"` | "El nombre del cliente no puede empezar o terminar con espacios" |
| `"Juan  Pérez"` | "El nombre del cliente no puede tener múltiples espacios consecutivos" |
| `"Juan123 Pérez"` | "El nombre del cliente solo puede contener letras, espacios, puntos, guiones y apostrofes" |
| `"Juan"` | "El nombre del cliente debe tener al menos nombre y apellido" |
| `"Juan Carlos María Elena Pérez García López Martínez Rodríguez"` | "El nombre del cliente no puede tener más de 8 palabras" |

## 🎯 **Casos de Prueba Recomendados:**

### **Prueba 1: Nombres Típicos Españoles**
```
✅ "José María García López"
✅ "María Elena Pérez"
✅ "Juan Carlos Martínez"
✅ "Ana María Rodríguez"
```

### **Prueba 2: Nombres con Acentos**
```
✅ "José María"
✅ "María José"
✅ "José Antonio"
✅ "María Elena"
```

### **Prueba 3: Nombres Compuestos**
```
✅ "Jean-Pierre"
✅ "O'Connor"
✅ "María-José"
✅ "José-María"
```

### **Prueba 4: Nombres con Caracteres Únicos**
```
✅ "A B" (nombre y apellido de 1 carácter)
✅ "J Pérez" (nombre de 1 carácter)
✅ "Juan P" (apellido de 1 carácter)
✅ "A García" (nombre de 1 carácter)
✅ "María J" (apellido de 1 carácter)
```

### **Prueba 5: Nombres Largos Extranjeros**
```
✅ "Simón José Antonio de la Santísima Trinidad Bolívar" (8 palabras)
✅ "María Elena José Antonio Carlos García López Martínez" (7 palabras)
✅ "Juan Carlos María Elena Pérez García López" (6 palabras)
✅ "José Antonio María Elena López Martínez" (5 palabras)
```

### **Prueba 6: Casos Límite**
```
❌ "A" (muy corto)
❌ "AB" (muy corto)
❌ "Simón José Antonio de la Santísima Trinidad Bolívar Ponte y Palacios Blanco" (muy largo - 12 palabras)
❌ " Juan Pérez" (espacio inicial)
❌ "Juan123 Pérez" (números)
```

## 🛠️ **Implementación Técnica:**

La validación se implementa en dos métodos:

1. **`validarCliente(String cliente)`**: Retorna `true` si es válido, `false` si no
2. **`obtenerMensajeErrorCliente(String cliente)`**: Retorna el mensaje de error específico

### **Flujo de Validación:**
1. Verificar que no esté vacío
2. Verificar longitud (3-100 caracteres)
3. Verificar que no empiece/termine con espacios
4. Verificar caracteres válidos (solo letras, espacios, guiones, puntos, apostrofes)
5. Verificar que no tenga múltiples espacios consecutivos
6. Verificar que tenga entre 2-8 palabras
7. Verificar que cada palabra tenga al menos 1 carácter
8. Verificar que cada palabra contenga solo letras

---

*Esta validación asegura que solo se acepten nombres de clientes con formato correcto y profesional.*
