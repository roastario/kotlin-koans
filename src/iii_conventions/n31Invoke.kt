package iii_conventions

import util.TODO


class Invokable{
    var count = 0;
    public operator fun invoke(): Invokable{
        count++;
        return this;
    }

    fun getNumberOfInvocations(): Int {
        return count;
    }
}

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
