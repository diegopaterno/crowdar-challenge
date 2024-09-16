# Proyecto de Automatización de Pruebas CROWDAR CHALLENGE

Este proyecto es un framework de pruebas automatizadas utilizando Java y Maven. Permite ejecutar pruebas en los navegadores Firefox y Chrome, y genera un reporte con Allure.

## Requisitos

- **Java**: Versión 8 o superior.
- **Maven**: Asegúrate de tener Maven instalado y configurado en tu entorno.

## Instrucciones de Uso

### 1. Descargar el Proyecto

Clona o descarga el proyecto desde el repositorio y navega al directorio del proyecto.

### 2. Ejecución de Pruebas

#### Ejecutar las pruebas en Chrome

Abre la consola (cmd) y ejecuta el siguiente comando:

```bash
mvn clean test -Dbrowser=Chrome
```
#### Ejecutar las pruebas en Firefox

Abre la consola (cmd) y ejecuta el siguiente comando:

```bash
mvn clean test -Dbrowser=Firefox
```
#### Apertura de reporte Allure

Desde la consola (cmd) ejecuta el siguiente comando:

```bash
allure serve allure-results
```