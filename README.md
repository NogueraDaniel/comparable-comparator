# comparable-comparator
Puesta en común entre las interfaces Comparable y Comparator, y sus usos más recurrentes.
Vamos a mostrar un proyecto donde implementamos ambas interfaces, para entender con mayor detalle cómo funcionan y cuáles son sus diferencias.

## Comparable:
Esta interfaz nos obliga a implementar el método **compareTo(Object o)**, el cual nos va a indicar si el objeto enviado por parámetro es mayor, menor o igual al objeto que está llamando al método.

Un uso frecuente seria cuando queremos ordenar una lista mediante el método estático **Collections.sort(List <T> lista)**.

Habrán visto que podemos ordenar listas de String, de Integer... pero ¿Qué pasa cuando creamos una lista de una _clase propia_ y llamamos al método **sort** de la clase Collections?
Nos arroja un ~~**error**~~ en el compilador…
### ¿Por qué? ##
Porque el método **Collections.sort(List <T> list)** recibe una lista de una **clase que _implemente_ Comparable**. String, Integer y todas las clases wrapper lo implementan…
En nuestro ejemplo, nuestra clase **Employee** implementa a la interfaz Comparable, y en nuestro método ordenamos a los empleados según su ID.
Ahora bien. Como es frecuente, puede que necesitemos ordenar a nuestros empleados con algún atributo diferente, como puede ser el nombre, la edad, el salario, etc.
Acá es donde entra en juego la interfaz funcional _**Comparator**_.
##Comparator:
Comparator es una interfaz funcional, por lo que nos permite instanciar el comparador y nos obliga a implementar su método **compare(Object o1, Object o2)**.
Este método va a indicar si el objeto 1 es mayor, menor o igual el objeto 2. ¿No es lo mismo que esta devolviendo el método _compareTo_ de la interfaz **Comparable**? Si, pero esta interfaz nos permite ejecutar una sobrecarga del método estático **Collections.sort**:
###Collections.sort(List<T> list, Comparator<? super T> c)##
Este método recibe 2 parámetros:
•	Recibe una lista y no necesita que la clase implemente ningún tipo de interfaz
•	Recibe un comparador que recibe como parámetro de clase <> a la misma clase de la lista. Él se encargará de ordenar nuestra lista según la implementación que propongamos.
Veámoslo en un ejemplo para que quede más claro:

Gracias a este mecanismo, vamos a poder crear cuantos comparadores quisiéramos siempre y cuando reciban el mismo parámetro de clase.
En nuestro proyecto creamos a la clase **SortHelpersEmployees** donde tenemos diferentes comparadores estáticos que van a ser utilizados en nuestro programa para ordenar a los empleados.
##Conclusión:##
•	Aunque Comparable y Comparator exploten métodos que parecieran ser iguales, no lo son. 
•	Comparable nos va a permitir un único ‘orden natural’ (Por decirlo de alguna manera) que va a ser utilizado por distintos métodos del api de Java, mientras que Comparator nos va a permitir diferentes tipos de ordenamientos.
•	Comparable necesita ser implementado por una clase, mientras que Comparator no.
##Diagrama de clases:##

##Información del proyecto:##
Proyecto creado en Eclipse compatible con NetBeans.
