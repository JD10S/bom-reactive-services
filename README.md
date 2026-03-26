# BOM Reactive Microservice

## 📌 Descripción

Microservicio reactivo desarrollado con Spring Boot WebFlux que simula un módulo básico de Bill of Materials (BOM) en un sistema MRP.

Permite calcular de forma dinámica los materiales requeridos para una producción basada en la estructura de un producto.

---

## 🚀 Tecnologías

* Java 21
* Spring Boot WebFlux
* Maven
* Programación reactiva (Mono / Flux)
* Lombok

---

## 🧱 Arquitectura

El proyecto sigue una arquitectura por capas:

* **model** → Entidades
* **repository** → Persistencia en memoria
* **service** → Lógica de negocio
* **handler** → Manejo de requests (WebFlux funcional)
* **router** → Definición de endpoints

---

## ▶️ Ejecución

1. Clonar repositorio:

```
git clone <URL_DEL_REPO>
```

2. Abrir en IntelliJ IDEA

3. Ejecutar:

```
BomServiceApplication
```

4. Servidor disponible en:

```
http://localhost:8080
```

---

## 🔗 Endpoints

### Crear producto

**POST** `/products`

```json
{
  "name": "Zapato"
}
```

---

### Agregar material

**POST** `/products/{productId}/materials`

```json
{
  "material": "Cuero",
  "quantity": 2
}
```

---

### Calcular producción

**GET** `/production/calculate?productId=1&quantity=100`

---

## 📊 Ejemplo de respuesta

```json
{
  "product": "Zapato",
  "quantity": 100,
  "materials": [
    {
      "material": "Cuero",
      "required": 200
    }
  ]
}
```

---

## 🧠 Consideraciones técnicas

* Se utilizó programación reactiva con `Mono` y `Flux`.
* Persistencia en memoria con estructuras concurrentes.
* Manejo básico de errores con `switchIfEmpty`.
* Arquitectura preparada para escalar a base de datos reactiva (R2DBC).

---

## ✅ Estado del proyecto

✔ Funcional
✔ Cumple requerimientos de la prueba
✔ Listo para evaluación técnica
