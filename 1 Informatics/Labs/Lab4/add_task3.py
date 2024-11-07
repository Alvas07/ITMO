import re

def parse_json_number(string):
    result = ""

    num_chars = "0123456789-+.eE"
    for char in string:
        if char in num_chars:
            result += char
        else:
            break

    if result.isnumeric():
        return int(result), string[len(result):].strip()
    else:
        try:
            return float(result), string[len(result):].strip()
        except ValueError:
            return None


def parse_json_string(string):
    if not string.startswith('"'):
        return None

    result = ""
    last_quote = string.find('"', 1)
    if last_quote != -1:
        return string[1:last_quote], string[last_quote+1:].strip()
    else:
        return None


def parse_json_bull(string):
    if string.startswith("true"):
        return 'true', string[4:].strip()
    if string.startswith("false"):
        return 'false', string[5:].strip()


def parse_json_null(string):
    if string.startswith('null'):
        return None, string[4:].strip()


def parse_json_comma(string):
    if string.startswith(","):
        return ",", string[1:].strip()


def parse_json_colon(string):
    if string.startswith(":"):
        return ":", string[1:].strip()


def parse_json_keyvalue(string):
    key = parse_json_string(string)
    if not key:
        return None
    colon = parse_json_colon(key[1])
    if not colon:
        return None
    value = parse_json_value(colon[1])
    if not value:
        return None
    return (key[0], value[0]), value[1]


def parse_json_separated_keyvalues(string):
    result = {}
    while True:
        keyvalue = parse_json_keyvalue(string)
        if not keyvalue:
            break
        key, value = keyvalue[0]
        string = keyvalue[1]
        result[key] = value

        comma = parse_json_comma(string)
        if not comma:
            break
        string = comma[1]

    return result, string.strip()


def parse_json_dictionary(string):
    if not string.startswith("{"):
        return None
    dictionary, string = parse_json_separated_keyvalues(string[1:])
    if not string.startswith("}"):
        return None
    return dictionary, string[1:].strip()


def parse_json_separated_values(string):
    result = []
    while True:
        value = parse_json_value(string)
        if not value:
            break
        result.append(value[0])
        string = value[1]

        comma = parse_json_comma(string)
        if not comma:
            break
        string = comma[1]

    return result, string.strip()


def parse_json_list(string):
    if not string.startswith("["):
        return None
    lst, string = parse_json_separated_values(string[1:])
    if not string.startswith("]"):
        return None
    return lst, string[1:].strip()


def parse_json_value(string):
    parses = [parse_json_number(string), parse_json_string(string), parse_json_bull(string), parse_json_null(string), parse_json_dictionary(string), parse_json_list(string)]
    for parse in parses:
        if parse:
            return parse[0], parse[1].strip()


def parse_json(json_file_path):
    with open(json_file_path, "r", encoding="utf-8") as json_file:
        json_string = json_file.read().strip().replace("\n", "")
        json_string = re.sub(r"\s\s+", "", json_string)

    return parse_json_value(json_string)[0]


def convert_xml_list(xml_file, name, xml_list):
    global xml_tabs

    xml_file.write("\t" * xml_tabs + f'<{name} type="list">\n')
    xml_tabs += 1
    for item in xml_list:
        if isinstance(item, str):
            xml_file.write("\t" * xml_tabs + f'<{name}_item type="str">{item}</{name}_item>\n')
        elif isinstance(item, int):
            xml_file.write("\t" * xml_tabs + f'<{name}_item type="int">{item}</{name}_item>\n')
        elif isinstance(item, float):
            xml_file.write("\t" * xml_tabs + f'<{name}_item type="float">{item}</{name}_item>\n')
        elif isinstance(item, dict):
            xml_file.write("\t" * xml_tabs + f'<{name}_item type="dict">\n')
            xml_tabs += 1
            convert_xml_dict(xml_file, item)
            xml_tabs -= 1
            xml_file.write("\t" * xml_tabs + f"</{name}_item>\n")
    xml_tabs -= 1
    xml_file.write("\t" * xml_tabs + f"</{name}>\n")


def convert_xml_dict(xml_file, dictionary):
    global xml_tabs

    for key, value in dictionary.items():
        if isinstance(value, str):
            xml_file.write("\t" * xml_tabs + f'<{key} type="str">{value}</{key}>\n')
        elif isinstance(value, int):
            xml_file.write("\t" * xml_tabs + f'<{key} type="int">{value}</{key}>\n')
        elif isinstance(value, float):
            xml_file.write("\t" * xml_tabs + f'<{key} type="float">{value}</{key}>\n')
        elif isinstance(value, list):
            convert_xml_list(xml_file, key, value)
        else:
            xml_file.write("\t" * xml_tabs + f'<{key} type="dict">\n')
            xml_tabs += 1
            convert_xml_dict(xml_file, value)
            xml_tabs -= 1
            xml_file.write("\t" * xml_tabs + f"</{key}>\n")

def convert_json_to_xml(json_file_path):
    global xml_tabs
    xml_tabs = 1

    dictionary = parse_json(json_file_path)

    with open("data/out3.xml", "w", encoding="utf-8") as xml_file:
        xml_file.write('<?xml version="1.0" encoding="UTF-8"?>\n')
        xml_file.write('<root>\n')
        convert_xml_dict(xml_file, dictionary)
        xml_file.write('</root>')


convert_json_to_xml("data/in.json")

