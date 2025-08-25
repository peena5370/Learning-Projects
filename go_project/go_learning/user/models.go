package user // This file belongs to the 'user' package

import (
	"fmt"
	"strings"
	"time" // Used for CalculateAge example if it were here, but it's in tool package for this exercise
)

// UserModel represents a user in the system.
// Fields start with a lowercase letter, making them unexported (private)
// within the 'user' package, enforcing encapsulation.
type UserModel struct {
	id    string // Unique identifier for the user
	name  string // User's full name
	email string // User's email address
}

// NewUserModel is a constructor-like function that creates and returns
// a pointer to a new UserModel instance. Using a pointer receiver (*UserModel)
// is idiomatic for methods that might modify the struct or if the struct
// is large, to avoid copying.
func NewUserModel(id, name, email string) *UserModel {
	return &UserModel{
		id:    id,
		name:  name,
		email: email,
	}
}

// --- Getter Methods for UserModel ---

// GetID returns the user's ID.
// Methods also follow the export rule: capital letter means public.
func (u *UserModel) GetID() string {
	return u.id
}

// GetName returns the user's name.
func (u *UserModel) GetName() string {
	return u.name
}

// GetEmail returns the user's email.
func (u *UserModel) GetEmail() string {
	return u.email
}

// --- Setter Methods for UserModel ---

// SetName updates the user's name.
func (u *UserModel) SetName(newName string) {
	u.name = newName
}

// SetEmail updates the user's email.
// Includes a simple validation example.
func (u *UserModel) SetEmail(newEmail string) {
	// In a real application, more robust email validation would be here.
	if len(newEmail) > 0 && strings.Contains(newEmail, "@") { // Simple check for '@'
		u.email = newEmail
	} else {
		fmt.Printf("Warning: Invalid email format for %s: %s\n", u.name, newEmail)
	}
}

// DisplayUserInfo is a method to display user information.
func (u *UserModel) DisplayUserInfo() {
	fmt.Printf("User: ID=%s, Name=%s, Email=%s\n", u.id, u.name, u.email)
}

// AgentModel represents an agent in the system.
// Similar to UserModel, fields are unexported for encapsulation.
type AgentModel struct {
	id           string // Unique identifier for the agent
	name         string // Agent's name
	contactEmail string // Agent's primary contact email
	hireYear     int    // Year the agent was hired
}

// NewAgentModel is a constructor-like function for AgentModel.
func NewAgentModel(id, name, contactEmail string, hireYear int) *AgentModel {
	return &AgentModel{
		id:           id,
		name:         name,
		contactEmail: contactEmail,
		hireYear:     hireYear,
	}
}

// --- Getter Methods for AgentModel ---

func (a *AgentModel) GetID() string {
	return a.id
}

func (a *AgentModel) GetName() string {
	return a.name
}

func (a *AgentModel) GetContactEmail() string {
	return a.contactEmail
}

func (a *AgentModel) GetHireYear() int {
	return a.hireYear
}

// --- Setter Methods for AgentModel ---

func (a *AgentModel) SetName(newName string) {
	a.name = newName
}

func (a *AgentModel) SetContactEmail(newEmail string) {
	if len(newEmail) > 0 && strings.Contains(newEmail, "@") {
		a.contactEmail = newEmail
	} else {
		fmt.Printf("Warning: Invalid contact email format for agent %s: %s\n", a.name, newEmail)
	}
}

func (a *AgentModel) SetHireYear(year int) {
	currentYear := time.Now().Year() // Using time.Now().Year() for current year
	if year > 1900 && year <= currentYear {
		a.hireYear = year
	} else {
		fmt.Printf("Warning: Invalid hire year for agent %s: %d\n", a.name, year)
	}
}

// DisplayAgentInfo is a method to display agent information.
func (a *AgentModel) DisplayAgentInfo() {
	fmt.Printf("Agent: ID=%s, Name=%s, Email=%s, HireYear=%d\n", a.id, a.name, a.contactEmail, a.hireYear)
}
