def hamming_analyze(s):
    try:
        # проверяем, что пользователь ввёл строку из 0 и 1
        assert all(x in "01" for x in s) and len(s) == 7

        # вводим обозначения для проверочных и информационных разрядов
        symbols = ("r1", "r2", "i1", "r3", "i2", "i3", "i4")

        # разделяем строку на отдельные цифры
        digits = [int(x) for x in s]

        # считаем контрольные суммы
        s1 = (digits[0] + digits[2] + digits[4] + digits[6]) % 2
        s2 = (digits[1] + digits[2] + digits[5] + digits[6]) % 2
        s3 = (digits[3] + digits[4] + digits[5] + digits[6]) % 2

        # составляем синдром и проверяем сообщение на ошибки
        syndrome = (s1, s2, s3)
        if syndrome != (0, 0, 0):
            # находим позицию ошибки
            num = int("".join(list(map(str, syndrome))[::-1]), 2)
            digits[num - 1] = int(not digits[num - 1])
            print("Исходное сообщение неверно!")
            print(f"Ошибка в бите {symbols[num - 1]}")
        else:
            print("Исходное сообщение верно!")

        # выводим правильное сообщение
        print(f"Правильное сообщение: {digits[2]}{digits[4]}{digits[5]}{digits[6]}\n")

    # обрабатываем исключение
    except AssertionError:
        print("Можно ввести только строку длиной 7, состоящую из 0 и 1.\n")


s = input("Введите сообщение: ")
hamming_analyze(s)
