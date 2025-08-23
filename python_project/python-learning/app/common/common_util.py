import datetime
import json
import random

class CommonUtil:
    class_name = "CommonUtil"

    def __private_method_which_unable_access(self):
        print("this is a private method which unable to access by another classes")

    @staticmethod # a static method which written in python way
    def print_msg(msg: str = ""): 
        print(f"message printed: {msg}")

    def method_access_private_method(self):
        self.__private_method_which_unable_access()

    # an instance method which need to initialize class before using at other script
    def console_input_and_output(self):
        input1 = int(input("Please input integer: "))
        input2 = input("Please input a value: ") # if did not declare input type, will default input type to string
        print(f"type of input1={type(input1)}\tvalue={input1}")
        print(f"type of input2={type(input2)}\tvalue={input2}")
    
    def check_object_type(self):
        num1 = 123
        str1 = "this is string"
        bool1 = True
        num2 = 1.23 # in python, double is declared as float
        num3 = 22.1234567
        arr1 = [123, 456, 789]
        dict1 = {"key1": 123, "key2": 456}
        set1 = {"val1", "val2", "val3"} # not allow duplicate values
        tup1 = ("tup1", "tup2", "tup3")
        byt1 = b"apple"
        non1 = None

        print(type(num1))
        print(type(str1))
        print(type(bool1))
        print(type(num2))
        print(type(num3))
        print(type(arr1))
        print(type(dict1))
        print(type(set1))
        print(type(tup1))
        print(type(byt1))
        print(type(non1))
        
        print(f"dictonary get value by key: {dict1['key1']}")

    def object_value_assignation(self):
        num4: int = 1
        num5: int = 2
        str2: str = "this is string 2"
        bool2: bool = False
        num6: float = 3.1234567
        ran1 = random.randrange(1, 10)

        print(f"num4={num4}\tnum5={num5}\tstr2={str2}\tbool2={bool2}\tnum6={num6}\tran1={ran1}")
    
    def compare_value(self, val1: int, val2: int):
        if val1 > val2:
            print("val1 is bigger than val2")
        else:
            print("val1 is smaller than val2")
    
    def concat_string(self, input1: str, input2: str) -> str:
        result = input1 + " " + input2
        print(f"Concatenated string: {result}")
        
        return result

    def check_fruit(self, fruit_input: str):
        output: str = ""
        if(fruit_input == "apple"):
            output = "The inputted fruit is apple."
        elif(fruit_input == "pear"):
            output = "The inputted fruit is pear."
        else:
            output = "The inputted fruit is not in the selected list."
        
        print(f"{output}")
    
    def common_string(self):
        str3 = "Hello testing"
        print(f"sliced/substring str3={str3[6:]}\tslice start={str3[:5]}")
        str4 = " hello, string "
        print(f"trim/strip string: str4={str4.strip()}")
        print(f"replace string: str4={str4.replace("h", "H")}")
        print(f"split string str4={str4.strip().split(",")}")
    
    def common_list(self) -> list:
        list1 = ["apple", "pie", "banana"]
        list2 = ["bun", "orange", "pineapple"]
        list1.extend(list2) # can extend with tuple, set or dictionary
        print("extended list: ", list1)

        list2.append("pig")
        print("list2 append: ", list2)

        list2.insert(2, "cat")
        print("list2 insert with index: ", list2)

        tuple2 = ("kiwi", "grape")
        list1.extend(tuple2)
        print("list1 after extend with tuple: ", list1)

        dict2 = {"key1": 123, "key2": 456}
        list1.extend(dict2)
        print("list1 extend with dictionary", list1)

        return list1
    
    def loop_list(self, input_list: list):
        for obj in input_list:
            print(f"obj in list1: {obj}")
            if "kiwi" in obj:
                print("kiwi is inside the list")

    def match_weekday(self, input_day: int):
        match input_day:
            case 1:
                print("Monday")
            case 2:
                print("Tuesday")
            case 3:
                print("Wednesday")
            case 4:
                print("Thursday")
            case 5:
                print("Friday")
            case 6:
                print("Saturday")
            case 7:
                print("Sunday")
            case _:
                print("Not a valid weekday number")

    def output_current_date_time(self):
        return datetime.datetime.now()
    
    def output_datetime_to_string(self, year: int, month: int, day: int):
        return datetime.datetime(year, month, day).strftime("%d-%B-%Y")
    
    def str_to_json_obj(self, json_string: str):
        try:
            result = json.loads(json_string)

            return result
        except Exception as e:
            print(f"something went wrong when deserializing json string: {e}")
            return None
        finally:
            print("done converted the json string")

    def obj_to_json_str(self, obj):
        try:
            result = json.dumps(obj, indent=4)

            return result
        except Exception as e:
            print(f"something went wrong when serializing object to json string: {e}")
            return None
        
    def method_raise_exception(self):
        raise RuntimeError("something is wrong here")
    
    def is_value_is_int(self, val):
        if(type(val) is not int):
            raise TypeError("the input value is not integer")