"""
Python basic learning
"""

import asyncio
import threading
from service.async_role_service import AsyncRoleService
from database.async_db import get_db_session, engine
from service.sync_role_service import SyncRoleService
from database.sync_db import get_db
from config.pydantic_config import get_settings
from config.common_config import CommonConfig
from multithreading.common_threading import CommonThreading
from common.inherit_class import InheritUtilClass
from common.common_util import CommonUtil
from model.book import Book
from model.book_data import BookData
from model.book_pydantic import BookPydantic
from database.redis_db import delete_value, get_ttl, get_value, redis_connect, set_value


async def main():
    # Printline
    print("--- Print simple message ---")
    CommonUtil.print_msg("input string")

    util = CommonUtil()

    # Private method access
    print("\n--- Python accessing private method ---")
    util.method_access_private_method()

    # console input and output
    print("\n--- console input output ---")
    util.console_input_and_output()

    # Checking type of object
    print("\n--- object type checking ---")
    util.check_object_type()

    # Initialize object type
    # will throw error when you assign not valid value to the object
    print("\n--- object value assignation ---")
    util.object_value_assignation()

    # if---else statement
    print("\n--- if...else statement ---")
    util.compare_value(123, 456)

    # if---elseif---else statement
    print("\n--- if...else if...else statement ---")
    util.check_fruit("banana")

    # python string
    print("\n--- python string ---")
    util.common_string()

    # string concatenate
    print("\n--- string concatenate ---")
    return_val = util.concat_string("string1", "string2")
    print(f"Main method returnVal: {return_val}")

    # python list
    print("\n--- python list ---")
    return_list = util.common_list()

    # loop list
    util.loop_list(return_list)

    # sort list
    return_list.sort()
    print("sorted list ascending: ", return_list)

    # python match(swtich case for java)
    print("\n--- python match ---")
    util.match_weekday(100)
    util.match_weekday(2)

    # python model class
    print("\n--- python model class ---")
    book_model = Book("book1", 1234567890)
    print(f"book name: {book_model.book_name}, serial number: {book_model.serial_num}")

    book_data = BookData("book name1", 123456)
    print(
        f"book data using dataclass: {book_data.book_name}, serial: {book_data.book_serial}, publisher: {book_data.publisher}, isPublished: \
        {book_data.is_published}"
    )

    book_pydantic = BookPydantic(name="new book1", serial=22222222)
    print(f"book using pydantic to declare model class: {book_pydantic.name}")
    try:
        declare_wrong_type_val = BookPydantic(name=123456, serial=123456)  # type: ignore
    except Exception as e:
        print(f"exception occured when assigning wrong type of value: {e}")

    # python inheritance
    print("\n--- python inheritance and polymorphism ---")
    inherited_class = InheritUtilClass("MiaoMiao", "miao")
    print(
        f"inheritted class: name={inherited_class.name}, breed={inherited_class.breed}, speak: {inherited_class.speak()}"
    )
    inherited_class.print_child_and_parent_class_method()
    inherited_class.override_parent_class()

    # python datetime
    print("\n--- python datetime ---")
    current_date = util.output_current_date_time()
    print(
        f"current datetime is: {current_date}, year={current_date.year}, month={current_date.month}, day={current_date.day}"
    )
    print(f"string date: {util.output_datetime_to_string(2025, 12, 31)}")

    json_string = '{"name": "apple", "type": "fruit", "quantity": 100}'
    json_obj = util.str_to_json_obj(json_string)
    if json_obj != None:
        print(f"obj_name={json_obj["name"]}")

    obj_to_json = {"name": "pear", "type": "fruit", "quantity": 11}

    json_str = util.obj_to_json_str(obj_to_json)
    if json_str != None:
        print(f"json string is: {json_str}")

    # python raising exception
    print("\n--- python raising exception ---")
    try:
        util.method_raise_exception()
    except Exception as e:
        print(f"message throwned from the method: {e}")

    try:
        util.is_value_is_int("input string")
    except Exception as e:
        print(f"exception raised from the method: {e}")

    # python multithreading
    print("\n--- python multithreading ---")
    shared_list = []
    common_threading = CommonThreading(shared_list)

    thread1 = threading.Thread(target=common_threading.append_message, args=(1001, 5))
    thread2 = threading.Thread(target=common_threading.append_message, args=(1002, 5))

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    print("Final state of the shared list:")
    print(shared_list)
    print(f"Total messages appended: {len(shared_list)}")

    # python read config values
    print("\n--- python read config values ---")
    CommonConfig.get_config_values()

    settings = get_settings()
    print(
        f"pydantic settings: config.val1={settings.config.val1}, config.val2={settings.config.val2}, \
        database_host={settings.database_host}, database_password={settings.database_password}, \
            database_password(unencrypted)={settings.database_password.get_secret_value()}"
    )

    # python database
    print("\n--- python database ---")
    print("\n--- sync service ---")
    with next(get_db()) as db:
        sync_service = SyncRoleService()
        roles = sync_service.get_roles(db)

        if roles:
            for role in roles:
                print(f"role: {role.role_id}, role_name: {role.role_name}")

        create_role = sync_service.create_role(db, "test role name")
        if create_role:
            print(
                f"created role_id={create_role.role_id}, role_name={create_role.role_name}"
            )
            get_role = sync_service.get_role_by_id(db, create_role.role_id)  # type: ignore
            if get_role:
                print(
                    f"get created role by id={create_role.role_id}, get_role_id={get_role.role_id}, role_name={get_role.role_name}"
                )

            update_role = sync_service.update_role(db, create_role.role_id, "new update name")  # type: ignore
            if update_role:
                print(
                    f"updated role: role_id={update_role.role_id}, role_name={update_role.role_name}"
                )

            delete_status = sync_service.delete_role(db, update_role.role_id)  # type: ignore
            print(f"delete role status: {delete_status}")

    print("\n--- async service ---")
    async with get_db_session() as db:
        async_service = AsyncRoleService()
        roles = await async_service.get_roles(db)
        if roles:
            for role in roles:
                print(f"async role: {role.role_id}, role_name: {role.role_name}")

        create_role = await async_service.create_role(db, "test async role")
        if create_role:
            print(
                f"created async role_id={create_role.role_id}, role_name={create_role.role_name}"
            )

            get_role = await async_service.get_role_by_id(db, create_role.role_id)  # type: ignore
            if get_role:
                print(
                    f"get created async role by id={create_role.role_id}, get_role_id={get_role.role_id}, role_name={get_role.role_name}"
                )

            update_role = await async_service.update_role(db, create_role.role_id, "new async update name")  # type: ignore
            if update_role:
                print(
                    f"updated async role: role_id={update_role.role_id}, role_name={update_role.role_name}"
                )

            delete_status = await async_service.delete_role(db, update_role.role_id)  # type: ignore
            print(f"delete async role status: {delete_status}")

    await engine.dispose()

    # python redis
    print("\n--- python Redis ---")
    redis = redis_connect("localhost", 6379)

    key1 = "test:key:001"
    set_value(redis, key1, "demo_test_value2", 90)
    delete_value(redis, key1)
    key1_val = get_value(redis, key1)
    print(f"value after delete: {key1_val}")

    key2 = "test:key:002"
    set_value(redis, key2, "demo_test_value", 30)
    get_value(redis, key2)
    get_ttl(redis, key2)

    print("sleep for 35 second to get the value after expired")
    await asyncio.sleep(35)
    expired_val = get_value(redis, key2)
    print(f"value after sleep: {expired_val}")


if __name__ == "__main__":
    asyncio.run(main())
