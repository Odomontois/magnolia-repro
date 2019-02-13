scalaVersion := "2.12.8"

val magnoliaVersion = "0.10.0" 
//val magnoliaVersion = "0.7.1"

libraryDependencies += "com.propensive" %% "magnolia" % magnoliaVersion

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch)

scalacOptions ++= List(
  "-language:experimental.macros"
)