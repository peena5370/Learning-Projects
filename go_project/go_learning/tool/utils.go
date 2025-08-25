package tool // This file belongs to the 'tool' package

import (
	"fmt"
	"time" // For getting the current year

	"github.com/google/uuid" // For generating unique IDs
)

// CalculateAge calculates a person's age based on their birth year.
// This function is exported (public) because it starts with a capital 'C'.
func CalculateAge(birthYear int) int {
	currentYear := time.Now().Year()
	age := currentYear - birthYear
	if age < 0 {
		return 0 // Or handle as an error, depending on requirements
	}
	return age
}

// GenerateID generates a new UUID (Universally Unique Identifier).
// This function relies on an external package, which we'll manage with 'go mod'.
func GenerateID() string {
	newID := uuid.New()
	return newID.String() // Convert the UUID to its string representation
}

// PrintDelimiter prints a simple delimiter to the console.
func PrintDelimiter() {
	fmt.Println("\n----------------------------------------\n")
}
