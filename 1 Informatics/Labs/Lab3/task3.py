"""
Написать регулярное выражение, которое проверяет корректность email и в качестве
ответа выдаёт почтовый сервер (почтовый сервер - часть email идущая после "@").

Для простоты будем считать, что почтовый адрес может содержать в себе буквы,
цифры, "." и "_", а почтовый сервер только буквы и ".". При этом почтовый сервер
обязательно должен содержать верхний уровень домена (".ru", ".com", etc.).

Пример:
Ввод: students.spam@yandex.ru Вывод: yandex.ru
Ввод: example@example Вывод: Fail!
Ввод: example@example.com Вывод: example.com
"""

import re


def task3(text):
    pattern = r"[a-zA-z0-9\._]+@([a-zA-z]+\.[a-zA-z]+)"

    res = re.fullmatch(pattern, text)
    if res:
        ans = res.group(1)
    else:
        ans = "Fail!"

    return ans


tests = {
    "alvasid@gmail.com": "gmail.com",
    "example.ex_123@domen.abcd": "domen.abcd",
    "ex_ex@domen": "Fail!",
    "123321@123.ru": "Fail!",
    "spam.123.today@mail.ru": "mail.ru",
}

i = 1
for test in tests:
    print(f"Тест {i}: {test}")
    ans = tests[test]
    res = task3(test)
    if ans == res:
        print(f"Тест пройден успешно! Ответ: {res}.")
    else:
        print(
            f"Тест не пройден! Результат программы: {res}. Результат ручного подсчёта: {ans}."
        )
    i += 1
    print("-" * 40)
