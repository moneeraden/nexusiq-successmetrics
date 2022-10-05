package org.sonatype.cs.metrics.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("The fileIO service should")
public class TestFileIoServiceTestShould {
    @DisplayName("return true if a file exists")
    @Test
    void testFileExists() {
        try {
            Assertions.assertTrue(
                    FileIoService.fileExists("src/test/resources/iqmetrics/successmetrics.csv"));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @DisplayName("return IOexception if a file does not exist")
    @Test
    void testFileExistsFailure() {
        Assertions.assertFalse(FileIoService.fileExists("unknown file"));
    }

    @DisplayName("return a string containing the contents of a JSON file")
    @Test
    void testReadJsonAsString() throws IOException {
        Assertions.assertEquals(
                "{\"Title\": \"This is a title\"}\n",
                FileIoService.readJsonAsString("src/test/resources/test.json"));
    }

    @DisplayName("return a string containing the contents of a JSON file")
    @Test
    void testReadJsonAsStringFails() {
        Assertions.assertThrows(
                IOException.class,
                () -> {
                    FileIoService.readJsonAsString("unknown file");
                });
    }
}
