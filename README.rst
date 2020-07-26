Binarytree: Binary-Tree-with-Scala
----------------------------------------------------

.. image:: https://user-images.githubusercontent.com/2701938/34109703-4a8810aa-e3b9-11e7-8138-68eec47cfddb.gif
    :alt: Demo GIF


Introduction
============

You would see here an example of a Binary Tree made in Scala with functional programming.

Requirements
============

- Scala 2.13


Getting Started
===============

By default, **binarytree** uses the following class to represent a node:

.. code-block:: python

    case class NodoBin[A](valor:A ,  izq:Arbol[A] , der:Arbol[A]) extends Arbol[A]
    case object Vacio extends Arbol[Nothing]

Use the following object to set up the main structure of the tree:
.. code-block:: python
    
    object Arbol


Use the following trait to set up all the methods you want for the tree:

.. code-block:: python
    sealed trait Arbol[+A]

