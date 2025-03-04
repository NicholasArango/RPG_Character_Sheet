/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * 
 * Class: Spell Book
 * subclass of SpellList
 * public
 * 
 * Collaborators:
 *  Character Sheet, Menu Manager, Spell List
 * 
 * Responsibilities:
 *  Displays, and creates edit ability for available spells for a character
 *  Note: The Spell Book class will store a character's spells in a JSON file
 * 
 * Methods:
 *  SpellCreate Enum:
 *      private
 *      Parameters: none
 *      return: void/none
 *      Holds the character's spells, and is called to create the JSON file
 *      when the character is saved
 *  SpellGet():
 *      private
 *      Parameters: none
 *      return: boolean
 *      Gets chosen spells through input from the user, then
 *      Communicates with the Spell List class to obtain these spells
 *  SpellSet (int SelectSpell):
 *      private
 *      Parameters: Dictates spell chosen
 *      return: booleaen
 *      Communicates with the spell book to set the character's spells
 *  Display(SpellCreate Obj):
 *      private
 *      Parameters: grabs spells from the SpellCreate enum.
 *      return: string
 *      Displays the spells to the GUI
 */
public class SpellBook {

}
