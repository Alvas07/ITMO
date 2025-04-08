-- Функция для создания события и участия
CREATE OR REPLACE FUNCTION create_high_intensity_event()
RETURNS TRIGGER AS $$

DECLARE
    new_event_id INT; -- ID нового события
    creature_type TEXT; -- Тип существа

BEGIN
    IF NEW.intensity = 'H' THEN

        -- Получаем тип существа
        SELECT type INTO creature_type 
        FROM sensient_creature 
        WHERE id = NEW.creature_id;

        -- Создаем событие
        INSERT INTO event (title, data, description)
        VALUES (
            'Сильный всплеск эмоций: ' || NEW.type,
            CURRENT_DATE,
            'Существо "' || creature_type || '" испытало сильную эмоцию: ' || NEW.type
        )
        RETURNING id INTO new_event_id; -- Сохраняем ID созданного события

        -- Связываем существо с событием
        INSERT INTO participation (creature_id, event_id, role)
        VALUES (NEW.creature_id, new_event_id, 'Источник эмоции');

    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Триггер, срабатывающий после вставки или обновления эмоции
CREATE TRIGGER high_intensity_emotion_trigger
AFTER INSERT OR UPDATE ON emotion
FOR EACH ROW
EXECUTE FUNCTION create_high_intensity_event();