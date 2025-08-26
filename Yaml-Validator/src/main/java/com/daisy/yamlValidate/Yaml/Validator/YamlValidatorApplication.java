package com.daisy.yamlValidate.Yaml.Validator;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class YamlValidatorApplication {
    public static boolean isValidYAML(String fp) {
        LoaderOptions op = new LoaderOptions();
        Yaml yaml = new Yaml(new SafeConstructor(op));
        try (InputStream input = new FileInputStream(fp)) {
            yaml.load(input);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
            return false;
        } catch (Exception e) {
//			throw new RuntimeException(e);
            System.out.println("Invalid YAML: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String path = "D:\\Softwares\\YAML Crash Course\\YAML-Crash-Course\\Yaml-Validator\\src\\main\\YAML Learning Files\\one.yaml";
        if (isValidYAML(path)) {
            System.out.println(" The File is Valid YAML");
        } else {
            System.out.println(" The File is Not a Valid YAML");
        }
    }
}
