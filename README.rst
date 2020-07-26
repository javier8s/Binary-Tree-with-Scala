Binarytree: Binary-Tree-with-Scala
----------------------------------------------------

Introduction
============

Are you studying binary trees for your next exam, assignment or technical interview?

**Binarytree** is a Python library which provides a simple API to generate,
visualize, inspect and manipulate binary trees. It allows you to skip the
tedious work of setting up test data, and dive straight into practising your
algorithms. Heaps and BSTs (binary search trees) are also supported.

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

