package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("src/main/resources/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      String entryAsString = entry.toString();
      System.out.println(entryAsString);
      String userInput = scanner.nextLine();
      switch (userInput) {
        case "1":
          starWars.individuals().add(entry);
          break;
        case "2":
          hitchhikers.individuals().add(entry);
          break;
        case "3":
          marvel.individuals().add(entry);
          break;
        case "4":
          rings.individuals().add(entry);
          break;
        default:
          System.out.println("Invalid input");
      }
    }

    scanner.close();
    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
  }
}

record Universe(
        String name,
        List<JsonNode> individuals
) { }

class UniverseClassifier {
  Map<String, JsonNode> dict = new HashMap<>();

  public UniverseClassifier(JsonNode entry) {
    dict.put("isHumanoid", entry.get("isHumanoid"));
    dict.put("planet", entry.get("planet"));
    dict.put("age", entry.get("age"));
    dict.put("traits", entry.get("traits"));
  }

  public boolean isStarWars() {
    JsonNode isHumanoid = dict.get("isHumanoid");
    JsonNode planet = dict.get("planet");
    JsonNode age = dict.get("age");
    JsonNode traits = dict.get("traits");

    boolean isWookie = true;
    boolean isEwok = true;

    if (isHumanoid != null && isHumanoid.booleanValue()) {
      return false;
    }
    if (planet != null && !planet.asText().equals("Kashyyk")) {
      isWookie = false;
    }
    if (planet != null && !planet.asText().equals("Endor")) {
      isEwok = false;
    }
    if (isWookie && age != null) {
      isWookie = age.asInt() >= 0 && age.asInt() <= 400;
    }
    if (isEwok && age != null) {
      isEwok = age.asInt() >= 0 && age.asInt() <= 60;
    }
    if (isWookie && traits != null && !traits.isEmpty()) {
      isWookie = traits.get(0) != null && (traits.get(0).asText().equals("HAIRY") || traits.get(0).asText().equals("TALL"));
    }
    if (isWookie && traits != null && traits.size() > 1 && traits.get(1) != null) {
      isWookie = traits.get(1).asText().equals("TALL");
    }
    if (isEwok && traits != null && !traits.isEmpty()) {
      isEwok = traits.get(0) != null && (traits.get(0).asText().equals("SHORT") || traits.get(0).asText().equals("HAIRY"));
    }
    if (isEwok && traits != null && traits.size() > 1 && traits.get(1) != null) {
      isEwok = traits.get(1).asText().equals("HAIRY");
    }

    return isWookie || isEwok;
  }

  public boolean isMarvel() {
    JsonNode isHumanoid = dict.get("isHumanoid");
    JsonNode planet = dict.get("planet");
    JsonNode age = dict.get("age");
    JsonNode traits = dict.get("traits");

    boolean isAsgardian = true;

    if (isHumanoid != null && !isHumanoid.booleanValue()) {
      return false;
    }
    if (planet != null && !planet.asText().equals("Asgard")) {
      isAsgardian = false;
    }
    if (isAsgardian && age != null) {
      isAsgardian = age.asInt() >= 0 && age.asInt() <= 5000;
    }
    if (isAsgardian && traits != null && !traits.isEmpty()) {
      isAsgardian = traits.get(0) != null && (traits.get(0).asText().equals("BLONDE") || traits.get(0).asText().equals("TALL"));
    }
    if (isAsgardian && traits != null && traits.size() > 1 && traits.get(1) != null) {
      isAsgardian = traits.get(1).asText().equals("TALL");
    }
    return isAsgardian;
  }

  public boolean isHitchhikers() {
    JsonNode isHumanoid = dict.get("isHumanoid");
    JsonNode planet = dict.get("planet");
    JsonNode age = dict.get("age");
    JsonNode traits = dict.get("traits");


    boolean isBetelgeusian = true;
    boolean isVogons = true;

    if (isHumanoid != null && isHumanoid.booleanValue()) {
      isVogons = false;
    }
    else {
      isBetelgeusian = false;
    }
    if (planet != null && !planet.asText().equals("BETELGEUSE")) {
      isBetelgeusian = false;
    }
    if (planet != null && !planet.asText().equals("Vogsphere")) {
      isVogons = false;
    }
    if (isBetelgeusian && age != null) {
      isBetelgeusian = age.asInt() >= 0 && age.asInt() <= 100;
    }
    if (isVogons && age != null) {
      isVogons = age.asInt() >= 0 && age.asInt() <= 200;
    }
    if (isBetelgeusian && traits != null && !traits.isEmpty()) {
      isBetelgeusian = traits.get(0) != null && (traits.get(0).asText().equals("EXTRA_ARMS") || traits.get(0).asText().equals("EXTRA_HEAD"));
    }
    if (isBetelgeusian && traits != null && traits.size() > 1 && traits.get(1) != null) {
      isBetelgeusian = traits.get(1).asText().equals("EXTRA_HEAD");
    }
    if (isVogons && traits != null && !traits.isEmpty()) {
      isVogons = traits.get(0) != null && (traits.get(0).asText().equals("GREEN") || traits.get(0).asText().equals("BULKY"));
    }
    if (isVogons && traits != null && traits.size() > 1 && traits.get(1) != null) {
      isVogons = traits.get(1).asText().equals("BULKY");
    }

    return isBetelgeusian || isVogons;
  }

  public boolean isRing() {
    JsonNode isHumanoid = dict.get("isHumanoid");
    JsonNode planet = dict.get("planet");
    JsonNode age = dict.get("age");
    JsonNode traits = dict.get("traits");

    boolean isElf = true;
    boolean isDwarf = true;

    if (isHumanoid != null && !isHumanoid.booleanValue()) {
      return false;
    }
    if (planet != null && !planet.asText().equals("Earth")) {
      return false;
    }
    if (age != null) {
      isDwarf = age.asInt() >= 0 && age.asInt() <= 200;
    }
    if (traits != null && !traits.isEmpty()) {
      isElf = traits.get(0) != null && (traits.get(0).asText().equals("BLONDE") || traits.get(0).asText().equals("POINTY_EARS"));
    }
    if (isElf && traits != null && traits.size() > 1 && traits.get(1) != null) {
      isElf = traits.get(1).asText().equals("POINTY_EARS");
    }
    if (isDwarf && traits != null && !traits.isEmpty()) {
      isDwarf = traits.get(0) != null && (traits.get(0).asText().equals("SHORT") || traits.get(0).asText().equals("BULKY"));
    }
    if (isDwarf && traits != null && traits.size() > 1 && traits.get(1) != null) {
      isDwarf = traits.get(1).asText().equals("BULKY");
    }

    return isElf || isDwarf;
  }
}