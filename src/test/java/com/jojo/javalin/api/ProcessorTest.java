// package com.jojo.javalin.api;
//
// import io.avaje.http.generator.client.ClientProcessor;
// import io.avaje.http.generator.javalin.JavalinProcessor;
// import io.avaje.inject.generator.Processor;
// import java.io.File;
// import java.io.PrintWriter;
// import java.util.Collections;
// import java.util.List;
// import java.util.Set;
// import javax.tools.JavaFileObject;
// import javax.tools.JavaFileObject.Kind;
// import javax.tools.StandardLocation;
// import javax.tools.ToolProvider;
// import org.junit.jupiter.api.Test;
//
// class ProcessorTest {
//
//  @Test
//  public void runAnnoationProcessor() throws Exception {
//    final var source = "M:\\Dev\\Javalin-API/src";
//
//    final var files = getSourceFiles(source);
//
//    final var compiler = ToolProvider.getSystemJavaCompiler();
//
//    final var task =
//        compiler.getTask(
//            new PrintWriter(System.out),
//            null,
//            null,
//            List.of("--enable-preview", "--release=19"),
//            null,
//            files);
//    task.setProcessors(List.of(new JavalinProcessor(), new ClientProcessor(), new Processor()));
//
//    task.call();
//  }
//
//  private Iterable<JavaFileObject> getSourceFiles(String p_path) throws Exception {
//    final var compiler = ToolProvider.getSystemJavaCompiler();
//    final var files = compiler.getStandardFileManager(null, null, null);
//
//    files.setLocation(StandardLocation.SOURCE_PATH, List.of(new File(p_path)));
//
//    final Set<Kind> fileKinds = Collections.singleton(Kind.SOURCE);
//    return files.list(StandardLocation.SOURCE_PATH, "", fileKinds, true);
//  }
// }
