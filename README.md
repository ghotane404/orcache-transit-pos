# ORCache Transit

## Project Description

ORCache Transit POS is a Java-based console application inspired by my interest in learning how Washington State transit systems operate. 


This project was developed for Capstone 2 in the Year Up United Application Development track.This project was developed for Capstone 2 in the Year Up United Application Development track. 

I wanted to do something different and design the app around a Seattle-inspired transit fare model. It includes rider categories, transit services, fare add-ons, ferry upgrades, e-purse reloads, retail accessories, account features, card design options, checkout review, receipt file saving and other features!

<br>

---

## Project Features


The program includes several menu screens that guide the user through building a transit order.

### Home Menu

The application begins on the Home Menu.

| Option | Description      |
| ------ | ---------------- |
| 1      | Create New Order |
| 0      | Exit Application |

<br>
---

### Order Menu

The Order Menu acts as the central ordering hub.

| Option | Description          |
| ------ | -------------------- |
| 1      | Add Transit Pass     |
| 2      | Add Bundle Pass      |
| 3      | Add Retail Accessory |
| 4      | Add e-Purse Value    |
| 5      | Checkout             |
| 0      | Cancel Order         |


<br>

---

## Example Menu Flow and Transit Purchase



```text
========================================
               HOME MENU
========================================

1. New Order
0. Exit
----------------------------------------
Select an option:
```

<br>

```text

==================================================
                   ORDER MENU
==================================================

1. Add Transit Pass
2. Add Bundle Pass
3. Add Retail Item
4. Add e-Purse Balance 
5. Checkout

0. Cancel Order
--------------------------------------------------
Please select an option: 1

```

<br>

Base transit service selection
```text
==================================================
SELECT TRANSIT SERVICE
==================================================

1. Metro Bus
2. Link Light Rail
3. Rapid Ride
4. Sound Transit Express Bus

0. Cancel and Return to Order Menu
--------------------------------------------------
Please select an option: 1

```

<br>

Rider type selection for Adult, Senior, and Youth fares

```text

==================================================
              SELECT RIDER TYPE
==================================================

1. Adult (One-Way Pass)                  $   3.00
2. Senior (One-Way Pass)                 $   1.00
3. Youth (One-Way Pass)                  $   2.00
--------------------------------------------------
0. Cancel and Return to Order Menu

```

<b>



## Example Receipt 

```text
=================================================================
                            RECEIPT
=================================================================
Receipt ID:     1042
Date:           2026-05-29
Time:           14:37:18
Items:          4

-----------------------------------------------------------------
                       BASE TRANSIT SERVICE
-----------------------------------------------------------------
Adult One-Way Pass                                      $   3.00

-----------------------------------------------------------------
                       TRANSIT PASS ADD-ON
-----------------------------------------------------------------
Monthly Pass                                            $ 108.00

-----------------------------------------------------------------
                          ORDER TOTAL
-----------------------------------------------------------------
Grand Total                                             $ 111.00
```

<br>

---

## Pricing Logic

Pricing logic is centralized inside:

```text
TransitPricingModel.java
```

Responsibilities include:

* One-way transit pricing
* Rider type pricing
* Premium add-on pricing
* Ferry route pricing
* Discount multiplier calculations

Separating pricing logic from menu logic improves maintainability and keeps business rules centralized.

---

## Receipt

Once the items have been checked out, the system will generate and save the receipt with the title `20260528-225828.txt`. It will be stored in a receipt folder containing other receipts.
The application uses:

```text
ReceiptFileManager.java
```
<br>


**Responsibilities include:**

* Creating receipt directory
* Generating receipt filenames
* Formatting receipt output
* Writing receipt text files

<br>

Example filename:

```text
receipt-20260529-143522.txt
```

---



## OOP Concepts Used

### Abstraction

`TransactionLineItem` is an abstract parent class that represents a general item in an order. Specific order item types inherit from it.

```java
public abstract class TransactionLineItem
```

### Inheritance

Several classes extend `TransactionLineItem`, including:

- `TransitPassItem`
- `TransitPassAddOnItem`
- `FerryPassAddOnItem`
- `EPurseItem`
- `RetailAccessoryItem`
- `AccountFeatureItem`
- `CardStyleItem`
- `LimeVoucherItem`

---
### Polymorphism

The order stores items as `TransactionLineItem` objects. This allows the checkout process to work with different item types through one shared parent type.

```java
ArrayList<TransactionLineItem> currentOrderItems = new ArrayList<>();
```

The checkout can loop through the list and call shared methods like:

```java
item.getLineItemName();
item.getQuantity();
item.getTotalPrice();
```
---

### Encapsulation

Item classes store data in private fields and expose controlled access through constructors and getter methods.


---

## Capstone Requirements

This project was created for the **Year Up United Application Development Capstone 2 assignment**.

Requirements referenced in this implementation include:

* Java console application
* Menu-driven ordering workflow
* Object-oriented design

* Multiple product/item types
* Receipt generation
* File persistence
* Class organization and reusable architecture

---


## Technologies Used

* Java
* IntelliJ IDEA
* Git
* GitHub
* Object-Oriented Programming (OOP)
* File I/O




---

## How To Run

1. Open the project in IntelliJ IDEA.
2. Confirm the project SDK is set to a compatible Java version.
3. Open `Main.java`.
4. Run the `main` method.
5. Use the console menu options to build and checkout an order.


---


## Possible Future Improvements

* Convert remaining static menu fields and methods into instance-based objects. 
* Add stronger validation for menu input and quantity input. 
* Improve `TransactionService` to manage completed transaction records. 
* Expand `Transaction` so checkout can create a complete transaction object. 
* Add JUnit 5 tests for pricing, totals, discounts, and receipt formatting. 
* Save receipts with consistent timestamp-based file names. 
* Add an order summary screen before final checkout.


---

## Notes
- This project is console-based only. 
- ChatGPT was used to help with structuring and formatting the README.md, as well as implementing ANSI art. 

Thank you for reading the OrCache documentation.  

![img.png](img.png)
