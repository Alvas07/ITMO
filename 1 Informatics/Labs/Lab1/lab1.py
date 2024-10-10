def convert_decimal_to_fibonacci(n):
    try:
        # проверяем, что пользователь ввёл целое число
        assert n.isdigit()

        # преобразуем строку в число
        n = int(n)

        # отдельно обрабатываем случаи с n = 0 и n < 0
        if n == 0:
            return "0"
        elif n < 0:
            raise AssertionError

        # инициализируем первые два числа фибоначчи
        # пропускаем 0 и 1, которые не нужны для перевода
        fib1, fib2 = 1, 2
        count_of_digits = 2
        res = ""

        # считаем самое близкое к данному число фибоначчи,
        # а также кол-во цифр в итоговом числе
        while fib2 <= n:
            fib1, fib2 = fib2, fib1 + fib2
            count_of_digits += 1

        # учитываем возможное превышение исходного числа
        if fib2 > n:
            fib1, fib2 = fib2 - fib1, fib1
            count_of_digits -= 1

        # формируем итоговое число, поочерёдно вычитая
        # самые близкие к исходному числа фибоначчи
        # вычли - приписываем 1, иначе 0
        while n > 0:
            if n >= fib2:
                n -= fib2
                res += "1"
            else:
                res += "0"

            # переходим к предыдущей паре чисел фибоначчи
            fib1, fib2 = fib2 - fib1, fib1
            count_of_digits -= 1

        # если в итоговом числе не хватает цифр,
        # то дописываем справа нули
        res += "0" * count_of_digits

        return res

    # обрабатываем исключение, если ввели плохое число
    except AssertionError:
        return "Введённое число должно быть целым и неотрицательным."


x = input("Введите число: ")
res = convert_decimal_to_fibonacci(x)
if res.isdigit():
    print(
        f"{x} в 10 СС -> {res} в СС Фибоначчи (Цекендорфа)"
    )
else:
    print(res)
