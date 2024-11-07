import re

def parse_json_list(json_elems, json_len):
    global json_index

    result = []

    while json_index < json_len:
        json_index += 1

        if re.search(r"\]$", json_elems[json_index]):
            return result

        last_symbol = re.search(r".*$", json_elems[json_index]).group(0)
        if last_symbol == "[":
            result.append(parse_json_list(json_elems, json_len))
        elif last_symbol == "{":
            result.append(parse_json_dict(json_elems, json_len))
        elif json_elems[json_index].isnumeric():
            result.append(int(json_elems[json_index]))
        else:
            try:
                result.append(float(json_elems[json_index]))
            except ValueError:
                result.append(json_elems[json_index])


def parse_json_dict(json_elems, json_len):
    global json_index

    result = {}

    while json_index < json_len:
        json_index += 1

        if re.search(r"\}$", json_elems[json_index]):
            return result

        line = re.search(r'(.*): (\[|\{|(.*))', json_elems[json_index])
        key, value = line.group(1, 2)
        if value == "{":
            result[key] = parse_json_dict(json_elems, json_len)
        elif value == "[":
            result[key] = parse_json_list(json_elems, json_len)
        elif line.group(3).isnumeric():
            result[key] = int(line.group(3))
        else:
            try:
                result[key] = float(line.group(3))
            except ValueError:
                result[key] = line.group(3)


def parse_json(json_file_path):
    global json_index
    json_index = 0

    with open(f"{json_file_path}", "r", encoding="utf-8") as json_file:
        json_elems = [x for x in json_file]
        json_elems = [re.sub(r",?\n$", "", x) for x in json_elems]
        json_elems = [re.sub(r"^\s+", "", x) for x in json_elems]
        json_elems = [re.sub(r'"', "", x) for x in json_elems]
        json_len = len(json_elems)

    return parse_json_dict(json_elems, json_len)


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

    with open("data/out2.xml", "w", encoding="utf-8") as xml_file:
        xml_file.write('<?xml version="1.0" encoding="UTF-8"?>\n')
        xml_file.write('<root>\n')
        convert_xml_dict(xml_file, dictionary)
        xml_file.write('</root>')


convert_json_to_xml("data/in.json")