1. what if I want to add the last node?

```
public void addLast(int x) {
    size += 1;
    IntNode p = sentinel;
    while (p.next != null) {
        p = p.next;
    }

    p.next = new IntNode(x, null);
}

```
this is to slow, when my list become bigger and bigger. so we need a cache?

```
private IntNode last;

```

2. addLast getLast will be very quick , but what about the removeLast()? we don't have the seconde to last element.


