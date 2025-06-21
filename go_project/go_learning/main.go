package main // The 'main' package is the entry point of an executable Go program

import (
	"fmt"
	"go_learning/tool" // Import the 'tool' package from your module
	"go_learning/user" // Import the 'user' package from your module
)

func testSum(fn func(x, y int) int) int {
	return fn(5, 6)
}

func main() {
	fmt.Println("--- Starting Go Learning Project ---")
	tool.PrintDelimiter() // Using a function from the 'tool' package

	// --- Working with UserModel ---
	fmt.Println("Working with UserModel:")

	// Create a new user using the constructor-like function from the 'user' package
	user1 := user.NewUserModel(tool.GenerateID(), "Alice Wonderland", "alice@example.com")
	user1.DisplayUserInfo() // Call a method on the user object

	// Accessing fields using getter methods (due to encapsulation)
	fmt.Printf("User 1's ID: %s, Name: %s, Email: %s\n", user1.GetID(), user1.GetName(), user1.GetEmail())

	// Updating user info using setter methods
	user1.SetEmail("alice.w@newdomain.co")
	user1.SetName("Alice W.")
	user1.DisplayUserInfo()

	// Demonstrate invalid email
	user1.SetEmail("invalid-email")
	user1.DisplayUserInfo()
	tool.PrintDelimiter()

	// --- Working with AgentModel ---
	fmt.Println("Working with AgentModel:")

	// Create a new agent
	agent1 := user.NewAgentModel(tool.GenerateID(), "Bob The Builder", "bob@agentco.com", 2020)
	agent1.DisplayAgentInfo()

	// Accessing agent info
	fmt.Printf("Agent 1's Name: %s, Hire Year: %d\n", agent1.GetName(), agent1.GetHireYear())

	// Update agent info
	agent1.SetContactEmail("bob.t.builder@newcorp.net")
	agent1.SetHireYear(2021) // Valid update
	agent1.DisplayAgentInfo()

	agent1.SetHireYear(1800) // Invalid update
	agent1.DisplayAgentInfo()
	tool.PrintDelimiter()

	// --- Using functions from the 'tool' package ---
	fmt.Println("Using functions from 'tool' package:")

	birthYear := 1990
	age := tool.CalculateAge(birthYear)
	fmt.Printf("Born in %d, age is: %d\n", birthYear, age)

	newUUID := tool.GenerateID()
	fmt.Printf("Generated a new ID: %s\n", newUUID)

	fmt.Println("\n--- Go Learning Project Finished ---")

	tool.PrintDelimiter()

	fmt.Println("\n--- Go Array Start ----")
	var strArr [2]string
	strArr[0] = "test1"
	strArr[1] = "test2"

	fmt.Println("str array len: ", len(strArr), "\tarr1: ", strArr[0], "\tarr2: ", strArr[1])

	intArr := []int{2, 3, 5, 3, 6}

	fmt.Println("int array len: ", len(intArr))

	fmt.Println("--- Go Array End ---")

	fmt.Println("--- Go Array Start ---")

	sliceArr := []int{1, 2, 3, 4, 5, 6}

	sliceArr1 := sliceArr[0:2]
	sliceArr2 := sliceArr[2:4]
	fmt.Println("arr slice1: ", sliceArr1, "\tslice2: ", sliceArr2)

	fmt.Println("--- Go Array Slice End ---")

	fmt.Println("--- Go nil/null array ---")

	var nilArr []int
	fmt.Println("array: ", nilArr)

	if nilArr == nil {
		fmt.Println("is nil?: ", (nilArr == nil))
	} else {
		fmt.Println("not nil")
	}

	fmt.Println("--- Go nil/null array end ---")

	tool.PrintDelimiter()

	fmt.Println("--- Go map start ---")

	type Obj1 struct {
		a, b int
	}

	// initialize map object
	var objMap = make(map[string]Obj1)
	objMap["key1"] = Obj1{
		123, 333,
	}

	fmt.Println("map obj1: ", objMap["key1"].a)

	objMap2 := map[string]Obj1{
		"kkey1": {
			444, 666,
		},
		"kkey2": {
			777, 999,
		},
	}

	fmt.Println("map obj2: ", objMap2, "\tvalue: ", objMap2["kkey1"].b, "\tkkey2: ", objMap2["kkey2"])

	delete(objMap2, "kkey2")
	fmt.Println("remove kkey2: ", objMap2)

	fmt.Println("--- Go map end ---")

	tool.PrintDelimiter()

	fmt.Println("--- Go function parameter start ---")

	funObj := func(x, y int) int {
		return x + y
	}

	fmt.Println("object function: ", funObj(9, 9))
	fmt.Println("function inject object function", testSum(funObj))
}
