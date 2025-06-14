# Proyecto ANHQV API (Aquí no hay quien viva API)

Este proyecto tiene como objetivo crear una API basada en microservicios inspirada en la popular serie de televisión **"Aquí no hay quien viva" (ANHQV)**, siguiendo un modelo similar al de la reconocida [PokeAPI](https://pokeapi.co/). Permitirá a los desarrolladores acceder a información estructurada sobre personajes, la comunidad de vecinos y los pisos del icónico edificio de Desengaño 21.

---

## 🚧 Estado del Proyecto

**Estado Actual:** En Desarrollo

El proyecto se encuentra en sus primeras fases. Hemos establecido la infraestructura base para nuestra arquitectura de microservicios y estamos avanzando en la implementación de los servicios principales.

---

## 🧱 Componentes de la Arquitectura

Nuestra arquitectura se basa en un enfoque de **microservicios**, donde cada componente es autónomo y está encargado de un dominio específico.

### 1. API Gateway

- **Descripción:** Punto de entrada unificado para todos los clientes que interactúan con la ANHQV API. Es el "portero" de nuestro edificio digital.
- **Funcionalidad Principal:** Enrutamiento de peticiones, autenticación/autorización, limitación de peticiones, transformación de solicitudes.
- **Estado:** ✅ Implementado y configurado.

### 2. Eureka Server (Service Discovery)

- **Descripción:** Nuestro "listín telefónico" de servicios. Permite que los microservicios se registren y se descubran dinámicamente.
- **Funcionalidad Principal:** Registro y descubrimiento de servicios.
- **Estado:** ✅ Implementado y operativo.

---

## 🧩 Microservicios Principales (MVP)

### CharacterService (Servicio de Personajes)

- **Descripción:** Gestiona la información básica de los personajes de la serie.
- **Funcionalidad Principal:** Nombre, descripción, protagonismo, etc. No incluye roles comunitarios.
- **Estado:** 🟡 Planificado (Próximo a implementar)

### CommunityService (Servicio de la Comunidad)

- **Descripción:** Gestiona la estructura y dinámica interna de la comunidad de vecinos.
- **Funcionalidad Principal:**
  - Historial de roles (Presidente, Vocal, Portero, etc.).
  - Gestión de juntas, actas y acuerdos.
  - Lista de morosos.
- **Estado:** 🟡 Planificado (Próximo a implementar)

### ApartmentService (Servicio de Pisos y Locales)

- **Descripción:** Maneja la información de pisos y locales del edificio.
- **Funcionalidad Principal:**
  - Datos de propiedades (planta, letra, descripción).
  - Historial de ocupantes (personajes, períodos).
- **Estado:** 🟡 Planificado (Próximo a implementar)

---

## ⏭️ Próximos Pasos

Nuestro siguiente objetivo es comenzar la implementación del `CharacterService`.

---

## 🤝 Cómo Participar

¡Tu contribución es muy valiosa! Este proyecto es de código abierto y está abierto a la colaboración.

### Formas de Contribuir

- **🐞 Reportar Errores (Bugs):** Abre un *issue* describiendo el problema y los pasos para reproducirlo.
- **💡 Sugerir Mejoras o Funcionalidades:** Proponlo abriendo un *issue* para discutirlo.
- **💻 Contribuir con Código:** Sigue la guía que aparece más abajo.

### Guía para Contribuciones de Código (Pull Requests)

1. **Haz un Fork del Repositorio**
2. **Clona tu Fork Localmente**
3. **Crea una Nueva Rama** (ej. `feature/nueva-funcionalidad`)
4. **Realiza tus Cambios**
5. **Añade Pruebas (si aplica)**
6. **Realiza Commits Significativos**
7. **Empuja tus Cambios**
8. **Abre un Pull Request (PR)** explicando los cambios y su motivación

---

## 🧑‍💻 Estilo de Código y Directrices

- Sigue las convenciones estándar de **Java** y **Spring Boot**
- Utiliza **Lombok** para reducir código repetitivo (*boilerplate*)
- Mantén la coherencia con la estructura actual del proyecto

---

## ⚖️ Licencia

Este proyecto está licenciado bajo la **GNU GPL v3**. Para más detalles, consulta el archivo [LICENSE](./LICENSE).

---

## ℹ️ Aviso Legal

Este proyecto es una creación de fans sin afiliación ni respaldo oficial por parte de los titulares de derechos de la serie "Aquí no hay quien viva" (Miramón Mendi, Mediaset España, etc.). Su uso es únicamente con fines educativos y de entretenimiento.

---

Creado por **[@alvarowau](https://github.com/alvarowau)**  
¡Gracias de antemano por tu interés y futuras contribuciones!
