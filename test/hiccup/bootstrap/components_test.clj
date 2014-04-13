(ns hiccup.bootstrap.components_test
  (:use clojure.test
        hiccup.bootstrap.components
        hiccup.core))

(deftest navbar-test
  (testing "default"
    (is (re-find #"<button [^>]*data-target=\"#Foo-navbar-collapse\""
                 (html (navbar {:header "Foo"}))))
    (is (re-find #"<a class=\"navbar-brand\"[^>]*>Foo</a>"
                 (html (navbar {:header "Foo"}))))
    (is (re-find #"<div[^>]*id=\"Foo-navbar-collapse\">"
                 (html (navbar {:header "Foo"}))))
    (is (re-find #"<button [^>]*data-target=\"#Bar-navbar-collapse\""
                 (html (navbar {:header "Bar"}))))
    (is (re-find #"<a class=\"navbar-brand\"[^>]*>Bar</a>"
                 (html (navbar {:header "Bar"}))))
    (is (re-find #"<div[^>]*id=\"Bar-navbar-collapse\">"
                 (html (navbar {:header "Bar"}))))
    (is (re-find #"<li>Bar</li>"
                 (html (navbar {:header "Foo"
                                :items ["Bar"]}))))
    (is (re-find #"<li>Baz</li>"
                 (html (navbar {:header "Foo"
                                :items ["Baz"]}))))
    (is (re-find #"<li>Baz</li>"
                 (html (navbar {:header "Foo"
                                :items ["Bar" "Baz"]}))))
    (is (re-find #"<div class=\"container\">" (html (navbar nil))))
    (is (re-find #"<ul class=\"nav navbar-nav\"" (html (navbar nil))))))

