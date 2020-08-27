package chapter9packagesandinterfaces.stack;

class DynStack implements IntStack {
    private int stck[];
    private int tos;

    DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    @Override
    public void push(int item) {
        if (tos == stck.length - 1) {
            int temp[] = new int[stck.length * 2];

            for (int i = 0; i < stck.length; i++) {
                temp[i] = stck[i];
            }
            stck = temp;
            stck[++tos] = item;
        } else {
            stck[++tos] = item;
        }
    }

    @Override
    public int pop() {
        if (tos < 0) {
            System.out.println("Stack underflow.");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}

class IFTest2 {

    public static void main(String[] args) {
        DynStack myStack1 = new DynStack(5);
        DynStack myStack2 = new DynStack(8);

        for (int i = 0; i < 12; i++) {
            myStack1.push(i);
        }
        for (int i = 0; i < 20; i++) {
            myStack2.push(i);
        }

        System.out.println("Stack in myStack1: ");
        for (int i = 0; i < 12; i++) {
            System.out.print(myStack1.pop() + " ");
        }

        System.out.println();

        System.out.println("Stack in myStack2: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(myStack2.pop() + " ");
        }
    }
}
