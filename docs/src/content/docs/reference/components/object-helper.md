---
title: "Object Helper"
description: "Object Helper allows you to do various operations on objects."
---

Object Helper allows you to do various operations on objects.


Categories: helpers


Type: objectHelper/v1

<hr />




## Actions


### Add Value to the Object by Key
Name: addValueByKey

Add value to the object by key if it exists. Otherwise, update the value

#### Properties

|      Name       |      Label     |     Type     |     Description     | Required |
|:---------------:|:--------------:|:------------:|:-------------------:|:--------:|
| source | Source | OBJECT <details> <summary> Properties </summary> {} </details> | Source object to be added or updated | true |
| key | Key | STRING | Key of the value to be added or updated. | true |
| type | Type | STRING <details> <summary> Options </summary> ARRAY, BOOLEAN, DATE, DATE_TIME, INTEGER, NULL, NUMBER, OBJECT, STRING, TIME </details> | Type of value to be added or updated. | true |
| value | Value | ARRAY <details> <summary> Items </summary> [] </details> | Value to be added or updated. | true |
| value | Value | BOOLEAN <details> <summary> Options </summary> true, false </details> | Value to be added or updated. | true |
| value | Value | DATE | Value to be added or updated. | true |
| value | Value | DATE_TIME | Value to be added or updated. | true |
| value | Value | INTEGER | Value to be added or updated. | true |
| value | Value | NULL | Value to be added or updated. | true |
| value | Value | NUMBER | Value to be added or updated. | true |
| value | Value | OBJECT <details> <summary> Properties </summary> {} </details> | Value to be added or updated. | true |
| value | Value | STRING | Value to be added or updated. | true |
| value | Value | TIME | Value to be added or updated. | true |

#### Example JSON Structure
```json
{
  "label" : "Add Value to the Object by Key",
  "name" : "addValueByKey",
  "parameters" : {
    "source" : { },
    "key" : "",
    "type" : "",
    "value" : "00:00:00"
  },
  "type" : "objectHelper/v1/addValueByKey"
}
```

#### Output

The output for this action is dynamic and may vary depending on the input parameters. To determine the exact structure of the output, you need to execute the action.




### Add Key-Value Pairs to Object or Array
Name: addKeyValuePairs

Add values from list to object or array. If the source is object, the items in the list will be treated as Key-value pairs. If the value is array of objects, key-value pairs will be added to every object in the array.

#### Properties

|      Name       |      Label     |     Type     |     Description     | Required |
|:---------------:|:--------------:|:------------:|:-------------------:|:--------:|
| sourceType | Type of Initial Object | STRING <details> <summary> Options </summary> ARRAY, OBJECT </details> | Type of initial object to be added or updated. | true |
| source | Source | ARRAY <details> <summary> Items </summary> [{}] </details> | Source object to be added or updated | true |
| source | Source | OBJECT <details> <summary> Properties </summary> {} </details> | Source object to be added or updated | true |
| value | Key-Value Pairs | OBJECT <details> <summary> Properties </summary> {} </details> | Key-Value pairs to be added or updated. | true |

#### Example JSON Structure
```json
{
  "label" : "Add Key-Value Pairs to Object or Array",
  "name" : "addKeyValuePairs",
  "parameters" : {
    "sourceType" : "",
    "source" : { },
    "value" : { }
  },
  "type" : "objectHelper/v1/addKeyValuePairs"
}
```

#### Output

The output for this action is dynamic and may vary depending on the input parameters. To determine the exact structure of the output, you need to execute the action.




### Contains
Name: contains

Checks if the given key exists in the given object.

#### Properties

|      Name       |      Label     |     Type     |     Description     | Required |
|:---------------:|:--------------:|:------------:|:-------------------:|:--------:|
| input | Input | OBJECT <details> <summary> Properties </summary> {} </details> | Object that you'd like to check. | true |
| key | Key | STRING | Key to check for existence. | true |

#### Example JSON Structure
```json
{
  "label" : "Contains",
  "name" : "contains",
  "parameters" : {
    "input" : { },
    "key" : ""
  },
  "type" : "objectHelper/v1/contains"
}
```

#### Output



Type: BOOLEAN








### Delete Key-Value Pair
Name: deleteKeyValuePair

Deletes a key-value pair in the given object by the specified key. Returns the modified object.

#### Properties

|      Name       |      Label     |     Type     |     Description     | Required |
|:---------------:|:--------------:|:------------:|:-------------------:|:--------:|
| input | Input | OBJECT <details> <summary> Properties </summary> {} </details> | The object from which to delete the key-value pair. | true |
| key | Key | STRING | The key of the key-value pair to delete. | true |

#### Example JSON Structure
```json
{
  "label" : "Delete Key-Value Pair",
  "name" : "deleteKeyValuePair",
  "parameters" : {
    "input" : { },
    "key" : ""
  },
  "type" : "objectHelper/v1/deleteKeyValuePair"
}
```

#### Output

The output for this action is dynamic and may vary depending on the input parameters. To determine the exact structure of the output, you need to execute the action.




### Equals
Name: equals

Compares two objects and returns true if they are equal.

#### Properties

|      Name       |      Label     |     Type     |     Description     | Required |
|:---------------:|:--------------:|:------------:|:-------------------:|:--------:|
| source | Source | OBJECT <details> <summary> Properties </summary> {} </details> | The source object to compare. | true |
| target | Target | OBJECT <details> <summary> Properties </summary> {} </details> | The target object to compare against. | true |

#### Example JSON Structure
```json
{
  "label" : "Equals",
  "name" : "equals",
  "parameters" : {
    "source" : { },
    "target" : { }
  },
  "type" : "objectHelper/v1/equals"
}
```

#### Output



Type: BOOLEAN








### Merge Two Objects
Name: mergeTwoObjects

Merge two objects into one. If there is any property with the same name, the source value will be used.

#### Properties

|      Name       |      Label     |     Type     |     Description     | Required |
|:---------------:|:--------------:|:------------:|:-------------------:|:--------:|
| source | Source | OBJECT <details> <summary> Properties </summary> {} </details> | The source object to merge. | true |
| target | Target | OBJECT <details> <summary> Properties </summary> {} </details> | The target object to merge into. | true |

#### Example JSON Structure
```json
{
  "label" : "Merge Two Objects",
  "name" : "mergeTwoObjects",
  "parameters" : {
    "source" : { },
    "target" : { }
  },
  "type" : "objectHelper/v1/mergeTwoObjects"
}
```

#### Output

The output for this action is dynamic and may vary depending on the input parameters. To determine the exact structure of the output, you need to execute the action.






