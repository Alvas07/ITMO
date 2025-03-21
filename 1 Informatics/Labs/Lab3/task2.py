"""
Дан текст. Необходимо найти в нём каждый фрагмент, где сначала идёт слово "ВТ",
затем не более 4 слов, и после этого идёт слово "ИТМО".

Для простоты будем считать словом любую последовательность букв, цифр и знаков "_" (то есть символов \\w).

Пример:
Ввод: А ты знал, что ВТ - лучшая кафедра в ИТМО?
Вывод: ВТ лучшая кафедра в ИТМО
"""

import re


def task2(text):
    ans = []

    # уберём лишние знаки препинания и пробелы из текста
    text = re.sub(r"-+", " ", text)
    text = re.sub(r",+", " ", text)
    text = re.sub(r"\.+", " ", text)
    text = re.sub(r":+", " ", text)
    text = re.sub(r";+", " ", text)
    text = re.sub(r"\s+", " ", text)

    patterns = [
        r"\bВТ\sИТМО\b",
        r"\bВТ\s\w+\sИТМО\b",
        r"\bВТ\s\w+\s\w+\sИТМО\b",
        r"\bВТ\s\w+\s\w+\s\w+\sИТМО\b",
        r"\bВТ\s\w+\s\w+\s\w+\s\w+\sИТМО\b",
    ]

    for pattern in patterns:
        ans += re.findall(pattern, text)

    return set(ans)


tests = {
    "А ты знал, что ВТ - лучшая кафедра в ИТМО?": [
        "ВТ лучшая кафедра в ИТМО",
    ],
    "А ты и не знал, что ВТ - самая лучшая из кафедр ИТМО на ВТ ИТМО": [
        "ВТ самая лучшая из кафедр ИТМО",
        "ВТ ИТМО",
    ],
    "ВТ на ВТ ВТ ИТМО ВТ ИВТ ИВТ ВТ ИТМО": [
        "ВТ ИТМО",
        "ВТ ВТ ИТМО",
        "ВТ на ВТ ВТ ИТМО",
        "ВТ ИВТ ИВТ ВТ ИТМО",
    ],
    "Без этого ВТ не нужно ВТ в ИТМО, ВТ, без ИТМО": [
        "ВТ в ИТМО",
        "ВТ не нужно ВТ в ИТМО",
        "ВТ без ИТМО",
    ],
    "Поступайте на ВТ в ИТМО, но не на ВТ, которое не в ИТМО": [
        "ВТ в ИТМО",
        "ВТ которое не в ИТМО",
    ],
}

i = 1
for test in tests:
    print(f"Тест {i}: {test}")
    ans = tests[test]
    res = task2(test)
    if all(x in ans for x in res):
        print(f"Тест пройден успешно! Ответ: {res}.")
    else:
        print(
            f"Тест не пройден! Результат программы: {res}. Результат ручного подсчёта: {ans}."
        )
    i += 1
    print("-" * 100)
