"""
Python basic learning
"""
import threading
from service.async_role_service import AsyncRoleService
from database.sync_db import get_db
from config.pydantic_config import get_settings
from config.common_config import CommonConfig
from multithreading.common_threading import CommonThreading
from common.inherit_class import InheritUtilClass
from common.common_util import CommonUtil
from model.book import Book
from model.book_data import BookData
from model.book_pydantic import BookPydantic

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
returnVal = util.concat_string("string1", "string2")
print(f"Main method returnVal: {returnVal}")

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
bookModel = Book("book1", 1234567890)
print(f"book name: {bookModel.book_name}, serial number: {bookModel.serial_num}")

bookData = BookData("book name1", 123456)
print(f"book data using dataclass: {bookData.book_name}, serial: {bookData.book_serial}, publisher: {bookData.publisher}, isPublished: \
      {bookData.is_published}")

bookPydantic = BookPydantic(name="new book1", serial=22222222)
print(f"book using pydantic to declare model class: {bookPydantic.name}")
try:
    declareWrongTypeVal = BookPydantic(name=123456, serial=123456) # type: ignore
except Exception as e:
    print(f"exception occured when assigning wrong type of value: {e}")

# python inheritance
print("\n--- python inheritance and polymorphism ---")
inheritedClass = InheritUtilClass("MiaoMiao", "miao")
print(f"inheritted class: name={inheritedClass.name}, breed={inheritedClass.breed}, speak: {inheritedClass.speak()}")
inheritedClass.print_child_and_parent_class_method()
inheritedClass.override_parent_class()

# python datetime
print("\n--- python datetime ---")
currentDate = util.output_current_date_time()
print(f"current datetime is: {currentDate}, year={currentDate.year}, month={currentDate.month}, day={currentDate.day}")
print(f"string date: {util.output_datetime_to_string(2025, 12, 31)}")

jsonString = '{"name": "apple", "type": "fruit", "quantity": 100}'
jsonObj = util.str_to_json_obj(jsonString)
if jsonObj != None:
    print(f"obj_name={jsonObj["name"]}")

objToJson = {
    "name": "pear",
    "type": "fruit",
    "quantity": 11
}

jsonStr = util.obj_to_json_str(objToJson)
if(jsonStr != None):
    print(f"json string is: {jsonStr}")

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
commonThreading = CommonThreading(shared_list)

thread1 = threading.Thread(target=commonThreading.append_message, args=(1001, 5))
thread2 = threading.Thread(target=commonThreading.append_message, args=(1002, 5))

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
print(f"pydantic settings: config.val1={settings.config.val1}, config.val2={settings.config.val2}, \
      database_host={settings.database_host}, database_password={settings.database_password}, \
        database_password(unencrypted)={settings.database_password.get_secret_value()}")

# python database
print("\n--- python database ---")
with next(get_db()) as db:
    sync_service = AsyncRoleService()
    roles = sync_service.get_roles(db)

    if(roles):
        for role in roles:
            print(f"role: {role.role_id}, role_name: {role.role_name}")