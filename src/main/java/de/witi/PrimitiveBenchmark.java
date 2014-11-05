package de.witi;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(value = 1, jvmArgs = { "-server", "-Xms2048m", "-Xmx2048m"})
public class PrimitiveBenchmark {
	private static final int N = 2_000_000;

	@Benchmark
	public int intMul() {
		int a = 1;
		for (int i = 0; i < N; i++) {
			a *= 3;
		}
		return a;
	}

	@Benchmark
	public byte byteMul() {
		byte a = 1;
		for (int i = 0; i < N; i++) {
			a *= 3;
		}
		return a;
	}

	@Benchmark
	public short shortMul() {
		short a = 1;
		for (int i = 0; i < N; i++) {
			a *= 3;
		}
		return a;
	}

	@Benchmark
	public int intArray() {
		int[] x = new int[N];
		for (int i = 0; i < N; i++) {
			x[i] = i;
		}
		return x[x[3]];
	}

	@Benchmark
	public byte byteArray() {
		byte[] x = new byte[N];
		for (int i = 0; i < N; i++) {
			x[i] = (byte) i;
		}
		return x[x[3]];
	}

	@Benchmark
	public short shortArray() {
		short[] x = new short[N];
		for (int i = 0; i < N; i++) {
			x[i] = (short) i;
		}
		return x[x[3]];
	}
}
