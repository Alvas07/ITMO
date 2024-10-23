"""
Программа должна считать число смайликов определённого вида в предложенном тексте.
Все смайлики имеют структуру: [глаза][нос][рот].
Вариант для ИСУ=465824: X-(
"""

import re


def task1(text):
    pattern = r"X-\("
    return len(re.findall(pattern, text))


tests = {
    "X-(((X-( X--(XX-(( X-(X-(": 5,
    "XXXX-((X-(-X-(": 3,
    "X-(x-( X- (": 1,
    "X -(x-(X(-(X--(": 0,
    "-(X-(((x-(--X(X-(  X- ( X-(": 3,
}
i = 1
for test in tests:
    print(f"Тест {i}: {test}")
    ans = tests[test]
    res = task1(test)
    if ans == res:
        print(f"Тест пройден успешно! Ответ: {res}.")
    else:
        print(
            f"Тест не пройден! Результат программы: {res}. Результат ручного подсчёта: {ans}."
        )
    i += 1
    print("-" * 35)
